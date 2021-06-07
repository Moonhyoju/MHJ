
// ChatServerDlg.cpp: 구현 파일
//

#include "pch.h"
#include "framework.h"
#include "ChatServer.h"
#include "ChatServerDlg.h"
#include "afxdialogex.h"
#include "CListenSocket.h"
#include "CChildSocket.h"


#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// 응용 프로그램 정보에 사용되는 CAboutDlg 대화 상자입니다.

class CAboutDlg : public CDialogEx
{
public:
	CAboutDlg();

// 대화 상자 데이터입니다.
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_ABOUTBOX };
#endif

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 지원입니다.

// 구현입니다.
protected:
	DECLARE_MESSAGE_MAP()
};

CAboutDlg::CAboutDlg() : CDialogEx(IDD_ABOUTBOX)
{
}

void CAboutDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CAboutDlg, CDialogEx)
END_MESSAGE_MAP()


// CChatServerDlg 대화 상자



CChatServerDlg::CChatServerDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_CHATSERVER_DIALOG, pParent)
	, m_strData(_T(""))
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void CChatServerDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Control(pDX, IDC_LIST1, m_List);
	DDX_Control(pDX, IDC_PORT_COMBO, m_PortComboBox);
	DDX_Control(pDX, IDC_LISTEN_BUTTON, m_ListenButton);
	DDX_Text(pDX, IDC_EDIT_DATA, m_strData);
	DDX_Control(pDX, IDC_BUTTON_SEND, m_ButtonSend);
}

BEGIN_MESSAGE_MAP(CChatServerDlg, CDialogEx)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_WM_DESTROY()
	ON_BN_CLICKED(IDC_LISTEN_BUTTON, &CChatServerDlg::OnBnClickedListenButton)
	ON_BN_CLICKED(IDC_BUTTON_SEND, &CChatServerDlg::OnBnClickeddButtonSend)

END_MESSAGE_MAP()


// CChatServerDlg 메시지 처리기

BOOL CChatServerDlg::OnInitDialog()
{
	CDialogEx::OnInitDialog();

	// 시스템 메뉴에 "정보..." 메뉴 항목을 추가합니다.

	m_PortComboBox.AddString(_T("6000"));
	m_PortComboBox.AddString(_T("7000"));
	m_PortComboBox.AddString(_T("8000"));
	m_PortComboBox.AddString(_T("9000"));
	m_PortComboBox.SetCurSel(0);


	// IDM_ABOUTBOX는 시스템 명령 범위에 있어야 합니다.
	ASSERT((IDM_ABOUTBOX & 0xFFF0) == IDM_ABOUTBOX);
	ASSERT(IDM_ABOUTBOX < 0xF000);

	CMenu* pSysMenu = GetSystemMenu(FALSE);
	if (pSysMenu != nullptr)
	{
		BOOL bNameValid;
		CString strAboutMenu;
		bNameValid = strAboutMenu.LoadString(IDS_ABOUTBOX);
		ASSERT(bNameValid);
		if (!strAboutMenu.IsEmpty())
		{
			pSysMenu->AppendMenu(MF_SEPARATOR);
			pSysMenu->AppendMenu(MF_STRING, IDM_ABOUTBOX, strAboutMenu);
		}
	}

	// 이 대화 상자의 아이콘을 설정합니다.  응용 프로그램의 주 창이 대화 상자가 아닐 경우에는
	//  프레임워크가 이 작업을 자동으로 수행합니다.
	SetIcon(m_hIcon, TRUE);			// 큰 아이콘을 설정합니다.
	SetIcon(m_hIcon, FALSE);		// 작은 아이콘을 설정합니다.

	// TODO: 여기에 추가 초기화 작업을 추가합니다.

	//m_pListenSocket = new CListenSocket;							//Listen 소켓 생성

	//
	////TCP 소켓을 생성하고 7000번 포트에서 연결 대기
	//if (m_pListenSocket->Create(7000, SOCK_STREAM))
	//{
	//	if (m_pListenSocket->Listen())
	//	{
	//	}
	//	else
	//	{
	//		AfxMessageBox(_T("연결 실패"));
	//	}
	//}

	//
	//else
	//{
	//	AfxMessageBox(_T("실패"));
	//}



	return TRUE;  // 포커스를 컨트롤에 설정하지 않으면 TRUE를 반환합니다.
}

void CChatServerDlg::OnSysCommand(UINT nID, LPARAM lParam)
{
	if ((nID & 0xFFF0) == IDM_ABOUTBOX)
	{
		CAboutDlg dlgAbout;
		dlgAbout.DoModal();
	}
	else
	{
		CDialogEx::OnSysCommand(nID, lParam);
	}
}

// 대화 상자에 최소화 단추를 추가할 경우 아이콘을 그리려면
//  아래 코드가 필요합니다.  문서/뷰 모델을 사용하는 MFC 애플리케이션의 경우에는
//  프레임워크에서 이 작업을 자동으로 수행합니다.

void CChatServerDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // 그리기를 위한 디바이스 컨텍스트입니다.

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// 클라이언트 사각형에서 아이콘을 가운데에 맞춥니다.
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// 아이콘을 그립니다.
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialogEx::OnPaint();
	}
}

// 사용자가 최소화된 창을 끄는 동안에 커서가 표시되도록 시스템에서
//  이 함수를 호출합니다.
HCURSOR CChatServerDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}


void CChatServerDlg::OnDestroy()
{
	CDialog::OnDestroy();

	POSITION pos;
	pos = m_pListenSocket->m_ptrChildSocketList.GetHeadPosition();
	CChildSocket* pChild = NULL;

	while (pos != NULL)
	{
		pChild = (CChildSocket*)m_pListenSocket->m_ptrChildSocketList.GetNext(pos);

		if (pChild != NULL)
		{
			pChild->ShutDown();
			pChild->Close();
			delete pChild;
		}
	}

	m_pListenSocket->ShutDown();
	m_pListenSocket->Close();
	delete m_pListenSocket;
}

void CChatServerDlg::OnBnClickedListenButton() 
{
	GetDlgItemText(IDC_LISTEN_BUTTON, m_strListenBtn);

	int CurSelect = m_PortComboBox.GetCurSel();
	CString temp = _T("");
	UINT PortNumber = 0;

	switch (CurSelect) {
	case 0: PortNumber = 6000;	break;
	case 1: PortNumber = 7000;	break;
	case 2: PortNumber = 8000;	break;
	case 3: PortNumber = 9000;	break;
	}

	if (m_strListenBtn == "대기") {
		m_pListenSocket = new CListenSocket;							//Listen 소켓 생성

		temp.Format(_T("[Port : %d] 서버 접속 대기"), PortNumber);

		//TCP 소켓을 생성하고 7000번 포트에서 연결 대기
		if (m_pListenSocket->Create(PortNumber, SOCK_STREAM))
		{
			if (m_pListenSocket->Listen())
			{
				m_List.AddString(temp);
				m_List.SetCurSel(m_List.GetCount() - 1);
				m_ListenButton.SetWindowTextW(_T("서버 닫기"));
			}
			else
			{
				AfxMessageBox(_T("연결 실패"));
			}
		}


		else
		{
			AfxMessageBox(_T("실패"));
		}
	}

	else if (m_strListenBtn == "서버 닫기") {
		CChatServerDlg::OnDestroy();
		temp.Format(_T("[Port : %d] 서버 종료"), PortNumber);

		m_List.AddString(temp);
		m_List.SetCurSel(m_List.GetCount() - 1);

		m_ListenButton.SetWindowTextW(_T("대기"));
	}

	
}
void CChatServerDlg::OnBnClickeddButtonSend()
{
	UpdateData(TRUE);

	CListenSocket* pServerSocket = (CListenSocket*)m_pListenSocket;


	
	pServerSocket->BroadCast(m_strData, m_strData.GetLength() * 2);



	m_strData = _T("");
	UpdateData(FALSE);

}

