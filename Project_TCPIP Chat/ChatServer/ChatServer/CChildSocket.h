#pragma once
#include "afxsock.h""
// CChildSocket 명령 대상

class CChildSocket : public CSocket
{
public:
	CChildSocket(void);
	~CChildSocket(void);

public:
	CAsyncSocket* m_pListenSocket;
	void SetListenSocket(CAsyncSocket* pSocket);
	virtual void OnClose(int nErrorCode);
	virtual void OnReceive(int nErrorCode);
};


