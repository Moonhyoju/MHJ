// CListenSocket.cpp: 구현 파일
//

#include "pch.h"
#include "ChatServer.h"
#include "CListenSocket.h"
#include "CChildSocket.h"
#include "ChatServerDlg.h"

// CListenSocket

CListenSocket::CListenSocket(void)
{
}

CListenSocket::~CListenSocket(void)
{
}
//클라이언트가 접속 요청을 해오면 호출되는 함수
void CListenSocket::OnAccept(int nErrorCode)
{
	CChildSocket* pChild = new CChildSocket();		//클라이언트와 연결할 데이터 소켓 객체를 생성하여

	BOOL check = Accept(*pChild);					//클라이언트의 접속을 허용하고 데이터 소켓과 연결한다.

	if (check == FALSE)
	{
		delete pChild;
		AfxMessageBox(_T("접속 허용 실패"));
		return;
	}

	CString strIPAddress = _T("");

	UINT uPortNumber = 0;

	pChild->GetPeerName(strIPAddress, uPortNumber);	//클라이언트 IP 주소, Port번호

	//CListenSocket 객체의 주소를 CChildSocket 객체에 알려주기 위한 함수를 호출
	pChild->SetListenSocket(this);					//CChildSocket 클래스에 사용자가 정의한 함수
	m_ptrChildSocketList.AddTail(pChild);

	//클라이언트가 접속해옴을 리스트에 출력
	CChatServerDlg* pMain = (CChatServerDlg*)AfxGetMainWnd();

	CString temp = _T("");
	temp.Format(_T("[%s : %d] 서버 접속 허용"), strIPAddress, uPortNumber);

	pMain->m_List.AddString(temp);
	pMain->m_List.SetCurSel(pMain->m_List.GetCount() - 1);


	CSocket::OnAccept(nErrorCode);
}

void CListenSocket::CloseClientSocket(CSocket* pChild)
{
	POSITION pos;
	pos = m_ptrChildSocketList.Find(pChild);


	CString strIPAddress = _T("");

	UINT uPortNumber = 0;

	pChild->GetPeerName(strIPAddress, uPortNumber);	//클라이언트 IP 주소, Port번호

	if (pos != NULL)
	{
		pChild->ShutDown();							//클라이언트와 연결된 데이터 소켓을 닫는다.
		pChild->Close();
	}

	m_ptrChildSocketList.RemoveAt(pos);				//리스트에서 제거한 후
	delete pChild;									//메모리에서 해제

	CChatServerDlg* pMain = (CChatServerDlg*)AfxGetMainWnd();

	CString temp = _T("");
	temp.Format(_T("[%s : %d] 클라이언트 종료"), strIPAddress, uPortNumber);

	pMain->m_List.AddString(temp);
	pMain->m_List.SetCurSel(pMain->m_List.GetCount() - 1);

}

void CListenSocket::EchoCast(CSocket* pChild1, char* pszBuffer, int len)
{
	POSITION pos;
	pos = m_ptrChildSocketList.GetHeadPosition();

	CChildSocket* pChild = NULL;

	while (pos != NULL)
	{
		pChild = (CChildSocket*)m_ptrChildSocketList.GetNext(pos);

		if (pChild == pChild1)
		{
			pChild->Send(pszBuffer, 1024);
		}
	}
}


void CListenSocket::BroadCast(CString pszBuffer, int len)
{
	POSITION pos;
	pos = m_ptrChildSocketList.GetHeadPosition();

	CChildSocket* pChild = NULL;

	while (pos != NULL)
	{
		pChild = (CChildSocket*)m_ptrChildSocketList.GetNext(pos);

		if (pChild != NULL)
		{
			pChild->Send(pszBuffer, len);
		}
	}
}
// CListenSocket 멤버 함수
