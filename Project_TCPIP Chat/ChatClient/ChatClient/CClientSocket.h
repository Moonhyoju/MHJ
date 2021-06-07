#pragma once
#include "afxsock.h"

// CClientSocket 명령 대상

class CClientSocket : public CSocket
{
public:
	CClientSocket(void);
	~CClientSocket(void);
	virtual void OnClose(int nErrorCode);
	virtual void OnReceive(int nErrorCode);
};


