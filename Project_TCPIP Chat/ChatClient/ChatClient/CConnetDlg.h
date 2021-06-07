#pragma once


// CConnetDlg 대화 상자

class CConnetDlg : public CDialogEx
{
	DECLARE_DYNAMIC(CConnetDlg)

public:
	CConnetDlg(CWnd* pParent = nullptr);   // 표준 생성자입니다.
	virtual ~CConnetDlg();


public:
	CString m_strIPAddress;								//IP 컨트롤에 입력받은 서버의 IP 주소를 저장할 변수
	CString m_strServerPort;

// 대화 상자 데이터입니다.
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_CConnetDlg };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 지원입니다.

	void OnBnClickedOK();

	BOOL OnInitDialog();

	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnCbnSelchangeServerportCombo();
	CComboBox m_ServerPortComboBox;
};
