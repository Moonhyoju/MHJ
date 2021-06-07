// CConnetDlg.cpp: 구현 파일
//

#include "pch.h"
#include "ChatClient.h"
#include "CConnetDlg.h"
#include "afxdialogex.h"


// CConnetDlg 대화 상자

IMPLEMENT_DYNAMIC(CConnetDlg, CDialogEx)

CConnetDlg::CConnetDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_CConnetDlg, pParent)
{

}

CConnetDlg::~CConnetDlg()
{
}

void CConnetDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Control(pDX, IDC_SERVERPORT_COMBO, m_ServerPortComboBox);
}


BEGIN_MESSAGE_MAP(CConnetDlg, CDialogEx)
	ON_BN_CLICKED(IDOK, &CConnetDlg::OnBnClickedOK)
END_MESSAGE_MAP()


// CConnetDlg 메시지 처리기


void CConnetDlg::OnBnClickedOK()
{
	GetDlgItemText(IDC_IPADDRESS1, m_strIPAddress);
	GetDlgItemText(IDC_SERVERPORT_COMBO, m_strServerPort);

	CDialogEx::OnOK();
}

BOOL CConnetDlg::OnInitDialog()
{
	CDialogEx::OnInitDialog();

	SetDlgItemText(IDC_IPADDRESS1, _T("127.0.0.1"));		//루프백으로 초기화

	m_ServerPortComboBox.AddString(_T("6000"));
	m_ServerPortComboBox.AddString(_T("7000"));
	m_ServerPortComboBox.AddString(_T("8000"));
	m_ServerPortComboBox.AddString(_T("9000"));
	m_ServerPortComboBox.SetCurSel(0);



	return TRUE;
}
