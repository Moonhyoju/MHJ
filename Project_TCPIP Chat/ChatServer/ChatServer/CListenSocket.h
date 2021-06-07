#pragma once
#include "afxsock.h""

// CListenSocket 명령 대상

class CListenSocket : public CSocket
{
public:
	CListenSocket(void);
	~CListenSocket(void);

public:
	//연결된 클라이언트 소켓 객체를 관리하는 리스트 객체 선언
	CPtrList m_ptrChildSocketList;
	virtual void OnAccept(int nErrorCode);
	void CloseClientSocket(CSocket* pChild);
	void EchoCast(CSocket* pChild, char* pszBuffer, int len);
	void BroadCast(CString pszBuffer, int len);

};


