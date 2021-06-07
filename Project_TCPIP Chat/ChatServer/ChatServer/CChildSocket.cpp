// CChildSocket.cpp: 구현 파일
//

#include "pch.h"
#include "ChatServer.h"
#include "CChildSocket.h"
#include "ChatServerDlg.h"

// CChildSocket

CChildSocket::CChildSocket(void)
{
}

CChildSocket::~CChildSocket(void)
{
}

//연결된 클라이언트의 소켓 주소를 m_pListenSocket에 저장
void CChildSocket::SetListenSocket(CAsyncSocket* pSocket)
{
	m_pListenSocket = pSocket;
}


//클라이언트 소켓이 닫히게 되면 호출되는 함수
void CChildSocket::OnClose(int nErrorCode)
{
	CListenSocket* pServerSocket = (CListenSocket*)m_pListenSocket;
	pServerSocket->CloseClientSocket(this);

	CSocket::OnClose(nErrorCode);
}


//클라이언트가 서버로 데이터를 보내게 되면 자동으로 호출되는 함수
void CChildSocket::OnReceive(int nErrorCode)
{
	CString temp = _T("");
	CString strIPAddress = _T("");

	UINT uPortNumber = 0;

	char szBuffer[1024];
	::ZeroMemory(szBuffer, 1024);

	GetPeerName(strIPAddress, uPortNumber);									//연결된 클라이언트의 IP주소와 Port번호를 알아낸다.

	int len = 0;
	if (len = Receive(szBuffer, 1024) > 0)
	{
		CChatServerDlg* pMain = (CChatServerDlg*)AfxGetMainWnd();			//데이터를 수신했다면 받은 메시지를 리스트에 출력

		temp.Format(_T("[%s : %d] %s"), strIPAddress, uPortNumber, szBuffer);

		pMain->m_List.AddString(temp);
		pMain->m_List.SetCurSel(pMain->m_List.GetCount() - 1);

		//연결된 모든 클라이언트 해당 메시지 에코
		CListenSocket* pServerSocket = (CListenSocket*)m_pListenSocket;
		pServerSocket->EchoCast(this, szBuffer, len);
	}
	
	CSocket::OnReceive(nErrorCode);

}
// CChildSocket 멤버 함수
