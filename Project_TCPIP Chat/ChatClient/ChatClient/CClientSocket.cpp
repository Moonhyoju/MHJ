// CClientSocket.cpp: 구현 파일
//

#include "pch.h"
#include "ChatClient.h"
#include "CClientSocket.h"

#include "ChatClientDlg.h"

// CClientSocket

CClientSocket::CClientSocket(void)
{
}

CClientSocket::~CClientSocket(void)
{
}


void CClientSocket::OnClose(int nErrorCode)
{
	CChatClientDlg* pMain = (CChatClientDlg*)AfxGetMainWnd();

	ShutDown();
	Close();

	CSocket::OnClose(nErrorCode);
	
	AfxMessageBox(_T("서버와 연결이 되어 있지 않습니다."));

	pMain->m_ButtonConnect.EnableWindow(TRUE);
	pMain->m_ButtonSend.EnableWindow(FALSE);
	pMain->m_List.AddString(_T("[서버 접속 실패]"));
	pMain->m_List.SetCurSel(pMain->m_List.GetCount() - 1);

}


void CClientSocket::OnReceive(int nErrorCode)
{
	CString temp = _T("");

	char szBuffer[1024];
	::ZeroMemory(szBuffer, 1024);

	if (Receive(szBuffer, 1024) > 0)
	{
		CChatClientDlg* pMain = (CChatClientDlg*)AfxGetMainWnd();

		temp.Format(_T("[Server Message] %s"), szBuffer);
		

		pMain->m_List.AddString(temp);
		pMain->m_List.SetCurSel(pMain->m_List.GetCount()-1);
	}

	CSocket::OnReceive(nErrorCode);
}
// CClientSocket 멤버 함수
