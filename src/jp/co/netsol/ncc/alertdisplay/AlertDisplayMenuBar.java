/**
 * Alert Displayメニューバーの実装です。
 *
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.components.*;
import jp.co.netsol.ncc.components.table.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class AlertDisplayMenuBar extends JMenuBar{

/* -----------------------------------------------------------------------------
 変数
----------------------------------------------------------------------------- */
	/** オブジェクト */
	private Returnable rt;
	/** AlertDisplayTable */
	private AlertDisplayTable table;

/* -----------------------------------------------------------------------------
 コンポーネント
----------------------------------------------------------------------------- */
	/** Fileメニュー */
	protected JMenu jMenuFile = new JMenu();
	/** 終了 */
	protected JMenuItem jMenuFileClose = new JMenuItem();
	/** Alert Management */
	protected JMenu jMenuManagement = new JMenu();
	/** Clear */
	protected JMenuItem jMenuManagementClear = new JMenuItem();
	/** Acknowledge */
	protected JMenuItem jMenuManagementAcknowledge = new JMenuItem();
	/** Unacknowledge */
	protected JMenuItem jMenuManagementUnacknowledge = new JMenuItem();
	/**ツール */
	protected JMenu jMenuTool = new JMenu();
	/** Sort */
	protected JMenu jMenuSort = new JMenu();
	/** Sortグループ */
	protected ButtonGroup JMenuSortGroup = new ButtonGroup();
	/** Sort AlertId */
	protected JRadioButtonMenuItem jMenuSortAlertId = new JRadioButtonMenuItem();
	/** Sort AlertDef */
	protected JRadioButtonMenuItem jMenuSortAlertDef = new JRadioButtonMenuItem();
	/** Sort ObjectId */
	protected JRadioButtonMenuItem jMenuSortObjectId = new JRadioButtonMenuItem();
	/** Sort ObjectClass */
	protected JRadioButtonMenuItem jMenuSortObjectClass = new JRadioButtonMenuItem();
	/** Sort Manager */
	protected JRadioButtonMenuItem jMenuSortManager = new JRadioButtonMenuItem();
	/** Sort ManagerClass */
	protected JRadioButtonMenuItem jMenuSortManagerClass = new JRadioButtonMenuItem();
	/** Sort Count */
	protected JRadioButtonMenuItem jMenuSortCount = new JRadioButtonMenuItem();
	/** Sort AckOper */
	protected JRadioButtonMenuItem jMenuSortAckOper = new JRadioButtonMenuItem();
	/** Sort CurrOper */
	protected JRadioButtonMenuItem jMenuSortCurrOper = new JRadioButtonMenuItem();
	/** Sort Severity */
	protected JRadioButtonMenuItem jMenuSortSeverity = new JRadioButtonMenuItem();
	/** Sort Status */
	protected JRadioButtonMenuItem jMenuSortStatus = new JRadioButtonMenuItem();
	/** Sort ClearedBy */
	protected JRadioButtonMenuItem jMenuSortClearedBy = new JRadioButtonMenuItem();
	/** Sort First */
	protected JRadioButtonMenuItem jMenuSortFirst = new JRadioButtonMenuItem();
	/** Sort Last */
	protected JRadioButtonMenuItem jMenuSortLast = new JRadioButtonMenuItem();
	/** Sort CrearedAt */
	protected JRadioButtonMenuItem jMenuSortCrearedAt = new JRadioButtonMenuItem();
	/** Sort AckedAt */
	protected JRadioButtonMenuItem jMenuSortAckedAt = new JRadioButtonMenuItem();
	/** Sort Text */
	protected JRadioButtonMenuItem jMenuSortText = new JRadioButtonMenuItem();
	/** Sort Ticket */
	protected JRadioButtonMenuItem jMenuSortTicket = new JRadioButtonMenuItem();
	/** Sort Severity */
//	private JMenu JMenuSortSeverity = new JMenu();
	/** Sort Severity Normal */
//	private JRadioButtonMenuItem jMenuSortSeverityNormal = new JRadioButtonMenuItem();
	/** Sort Severity Indeterminate */
//	private JRadioButtonMenuItem jMenuSortSeverityIndeterminate = new JRadioButtonMenuItem();
	/** Sort Severity Warning */
//	private JRadioButtonMenuItem jMenuSortSeverityWarning = new JRadioButtonMenuItem();
	/** Sort Severity Minor */
//	private JRadioButtonMenuItem jMenuSortSeverityMinor = new JRadioButtonMenuItem();
	/** Sort Severity Major */
//	private JRadioButtonMenuItem jMenuSortSeverityMajor = new JRadioButtonMenuItem();
	/** Sort Severity Critical */
//	private JRadioButtonMenuItem jMenuSortSeverityCritical = new JRadioButtonMenuItem();

/* -----------------------------------------------------------------------------
 コンストラクタ
----------------------------------------------------------------------------- */
	/**
	 * AlertDisplayMenuBarを構築します。
	 *
	 * @param rt		Returnable
	 * @param table		AlertDisplayTable
	 */
	public AlertDisplayMenuBar(Returnable rt, AlertDisplayTable table){
		super();

		this.rt = rt;
		this.table = table;

		// メニュー登録
		setMenuComponent();

		// メニューイベント
		setMenuEvent();
	}

/* -----------------------------------------------------------------------------
 メニュー登録
----------------------------------------------------------------------------- */
	/**
	 * メニューと登録します。
	 *
	 */
	protected void setMenuComponent(){
		// jMenuFile
		jMenuFile.setText( "File(F)" );
		jMenuFile.setMnemonic( KeyEvent.VK_F );
		// jMenuFileClose
		jMenuFileClose.setText( "Close(X)" );
		jMenuFileClose.setMnemonic( KeyEvent.VK_X );
		// add
		// jMenuFileClose
		jMenuFile.add( jMenuFileClose );
		// jMenuFile
		add( jMenuFile );

		// Alert Management
		jMenuManagement.setText("Alert Management(M)");
		jMenuManagement.setMnemonic(KeyEvent.VK_M);
		// jMenuManagement
		jMenuManagementClear.setText("Clear(C)");
		jMenuManagementClear.setMnemonic(KeyEvent.VK_C);
		// jMenuManagementAcknowledge
		jMenuManagementAcknowledge.setText("Acknowledge(A)");
		jMenuManagementAcknowledge.setMnemonic(KeyEvent.VK_A);
		// jMenuManagementUnacknowledge
		jMenuManagementUnacknowledge.setText("Unacknowledge(U)");
		jMenuManagementUnacknowledge.setMnemonic(KeyEvent.VK_U);
		// add
		// jMenuManagementClear
		jMenuManagement.add(jMenuManagementClear);
		// jMenuManagementAcknowledge
		jMenuManagement.add(jMenuManagementAcknowledge);
		// jMenuManagementUnacknowledge
		jMenuManagement.add(jMenuManagementUnacknowledge);
		// jMenuManagement
		add( jMenuManagement );


		// jMenuSort
		jMenuSort.setText("Sort(S)");
		jMenuSort.setMnemonic(KeyEvent.VK_S);
		// jMenuSortAlertId
		jMenuSortAlertId.setText("AlertId");
		// jMenuSortAlertDef
		jMenuSortAlertDef.setText("AlertDef");
		// jMenuSortObjectId
		jMenuSortObjectId.setText("ObjectId");
		// jMenuSortObjectClass
		jMenuSortObjectClass.setText("ObjectClass");
		// jMenuSortManager
		jMenuSortManager.setText("Manager");
		// jMenuSortManagerClass
		jMenuSortManagerClass.setText("ManagerClass");
		// jMenuSortCount
		jMenuSortCount.setText("Count");
		// jMenuSortAckOper
		jMenuSortAckOper.setText("AckOper");
		// jMenuSortCurrOper
		jMenuSortCurrOper.setText("CurrOper");
		// jMenuSortSeverity
		jMenuSortSeverity.setText("Severity");
		// jMenuSortStatus
		jMenuSortStatus.setText("Status");
		// jMenuSortClearedBy
		jMenuSortClearedBy.setText("ClearedBy");
		// jMenuSortFirst
		jMenuSortFirst.setText("First");
		// jMenuSortLast
		jMenuSortLast.setText("Last");
		// jMenuSortCrearedAt
		jMenuSortCrearedAt.setText("CrearedAt");
		// jMenuSortAckedAt
		jMenuSortAckedAt.setText("AckedAt");
		// jMenuSortText
		jMenuSortText.setText("Text");
		// jMenuSortTicket
		jMenuSortTicket.setText("Ticket");
		// jMenuSortTicket
		jMenuSortTicket.setText("Ticket");
/*
		// JMenuSortSeverity
		JMenuSortSeverity.setText("Severity");
		// jMenuSortSeverityNormal
		jMenuSortSeverityNormal.setText("Normal");
		// jMenuSortSeverityIndeterminate
		jMenuSortSeverityIndeterminate.setText("Indeterminate");
		// jMenuSortSeverityWarning
		jMenuSortSeverityWarning.setText("Warning");
		// jMenuSortSeverityMinor
		jMenuSortSeverityMinor.setText("Minor");
		// jMenuSortSeverityMajor
		jMenuSortSeverityMajor.setText("Major");
		// jMenuSortSeverityCritical
		jMenuSortSeverityCritical.setText("Critical");
*/
		// add
		// jMenuSortAlertId
		JMenuSortGroup.add(jMenuSortAlertId);
		jMenuSort.add(jMenuSortAlertId);
		// jMenuSortAlertDef
		JMenuSortGroup.add(jMenuSortAlertDef);
		jMenuSort.add(jMenuSortAlertDef);
		// jMenuSortObjectId
		JMenuSortGroup.add(jMenuSortObjectId);
		jMenuSort.add(jMenuSortObjectId);
		// jMenuSortObjectClass
		JMenuSortGroup.add(jMenuSortObjectClass);
		jMenuSort.add(jMenuSortObjectClass);
		// jMenuSortManager
		JMenuSortGroup.add(jMenuSortManager);
		jMenuSort.add(jMenuSortManager);
		// jMenuSortManagerClass
		JMenuSortGroup.add(jMenuSortManagerClass);
		jMenuSort.add(jMenuSortManagerClass);
		// jMenuSortCount
		JMenuSortGroup.add(jMenuSortCount);
		jMenuSort.add(jMenuSortCount);
		// jMenuSortAckOper
		JMenuSortGroup.add(jMenuSortAckOper);
		jMenuSort.add(jMenuSortAckOper);
		// jMenuSortCurrOper
		JMenuSortGroup.add(jMenuSortCurrOper);
		jMenuSort.add(jMenuSortCurrOper);
		// jMenuSortSeverity
		JMenuSortGroup.add(jMenuSortSeverity);
		jMenuSort.add(jMenuSortSeverity);
		// jMenuSortStatus
		JMenuSortGroup.add(jMenuSortStatus);
		jMenuSort.add(jMenuSortStatus);
		// jMenuSortClearedBy
		JMenuSortGroup.add(jMenuSortClearedBy);
		jMenuSort.add(jMenuSortClearedBy);
		// jMenuSortFirst
		JMenuSortGroup.add(jMenuSortFirst);
		jMenuSort.add(jMenuSortFirst);
		// jMenuSortLast
		JMenuSortGroup.add(jMenuSortLast);
		jMenuSort.add(jMenuSortLast);
		// jMenuSortCrearedAt
		JMenuSortGroup.add(jMenuSortCrearedAt);
		jMenuSort.add(jMenuSortCrearedAt);
		// jMenuSortAckedAt
		JMenuSortGroup.add(jMenuSortAckedAt);
		jMenuSort.add(jMenuSortAckedAt);
		// jMenuSortText
		JMenuSortGroup.add(jMenuSortText);
		jMenuSort.add(jMenuSortText);
		// jMenuSortTicket
		JMenuSortGroup.add(jMenuSortTicket);
		jMenuSort.add(jMenuSortTicket);
/*
		// jMenuSortSeverityNormal
		JMenuSortGroup.add(jMenuSortSeverityNormal);
		JMenuSortSeverity.add(jMenuSortSeverityNormal);
		// jMenuSortSeverityIndeterminate
		JMenuSortGroup.add(jMenuSortSeverityIndeterminate);
		JMenuSortSeverity.add(jMenuSortSeverityIndeterminate);
		// jMenuSortSeverityWarning
		JMenuSortGroup.add(jMenuSortSeverityWarning);
		JMenuSortSeverity.add(jMenuSortSeverityWarning);
		// jMenuSortSeverityMinor
		JMenuSortGroup.add(jMenuSortSeverityMinor);
		JMenuSortSeverity.add(jMenuSortSeverityMinor);
		// jMenuSortSeverityMajor
		JMenuSortGroup.add(jMenuSortSeverityMajor);
		JMenuSortSeverity.add(jMenuSortSeverityMajor);
		// jMenuSortSeverityCritical
		JMenuSortGroup.add(jMenuSortSeverityCritical);
		JMenuSortSeverity.add(jMenuSortSeverityCritical);

		// JMenuSortSeverity
		jMenuSort.add(JMenuSortSeverity);
*/

		// jMenuTool
		jMenuTool.setText("Tool(T)");
		jMenuTool.setMnemonic(KeyEvent.VK_T);
		// add
		// jMenuSort
		jMenuTool.add(jMenuSort);
		// jMenuTool
		add(jMenuTool);


	}

/* -----------------------------------------------------------------------------
 メニューイベント登録
----------------------------------------------------------------------------- */
	/**
	 * メニューイベントを登録します。
	 *
	 */
	protected void setMenuEvent(){
		// jMenuFileClose
		jMenuFileClose.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				((AlertDisplay)rt).close();
			}
		});

		// jMenuManagementClear
		jMenuManagementClear.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				synchronized(table){
					table.clearAlert();
				}
			}
		});
		// jMenuManagementAcknowledge
		jMenuManagementAcknowledge.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				synchronized(table){
					table.acknowledgeAlert();
				}
			}
		});
		// jMenuManagementUnacknowledge
		jMenuManagementUnacknowledge.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				synchronized(table){
					table.unacknowledgeAlert();
				}
			}
		});


		// jMenuSort
		jMenuSort.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e){
				Comparator comparator = table.getComparator();
				if(comparator == null){
					return;
				}

				if(comparator instanceof AlertComparatorFactory.ComparatorOfAlertId){
					jMenuSortAlertId.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfAlertDef){
					jMenuSortAlertDef.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfObjectId){
					jMenuSortObjectId.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfObjectClass){
					jMenuSortObjectClass.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfManager){
					jMenuSortManager.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfManagerClass){
					jMenuSortManagerClass.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfCount){
					jMenuSortCount.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfAckOper){
					jMenuSortAckOper.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfCurrOper){
					jMenuSortCurrOper.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfSeverity){
					jMenuSortSeverity.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfStatus){
					jMenuSortStatus.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfClearedBy){
					jMenuSortClearedBy.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfFirst){
					jMenuSortFirst.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfLast){
					jMenuSortLast.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfCrearedAt){
					jMenuSortCrearedAt.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfAckedAt){
					jMenuSortAckedAt.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfText){
					jMenuSortText.setSelected(true);
				}else
				if(comparator instanceof AlertComparatorFactory.ComparatorOfTicket){
					jMenuSortTicket.setSelected(true);
				}
			}
			public void menuDeselected(MenuEvent e){
			}
			public void menuCanceled(MenuEvent e){
			}
		});

		// jMenuSortAlertId
		jMenuSortAlertId.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_ALERTID));
				table.sort();
				jMenuSortAlertId.setSelected(true);
			}
		});
		// jMenuSortAlertDef
		jMenuSortAlertDef.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_ALERTDEF));
				table.sort();
				jMenuSortAlertDef.setSelected(true);
			}
		});
		// jMenuSortObjectId
		jMenuSortObjectId.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_OBJECTID));
				table.sort();
				jMenuSortObjectId.setSelected(true);
			}
		});
		// jMenuSortObjectClass
		jMenuSortObjectClass.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_OBJECTCLASS));
				table.sort();
				jMenuSortObjectClass.setSelected(true);
			}
		});
		// jMenuSortManager
		jMenuSortManager.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_MANAGER));
				table.sort();
				jMenuSortManager.setSelected(true);
			}
		});
		// jMenuSortManagerClass
		jMenuSortManagerClass.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_MANAGERCLASS));
				table.sort();
				jMenuSortManagerClass.setSelected(true);
			}
		});
		// jMenuSortCount
		jMenuSortCount.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
//				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_COUNT));
//				table.sort();
//				jMenuSortCount.setSelected(true);
processSort(AlertComparatorFactory.create(AlertComparatorFactory.SORT_COUNT), jMenuSortCount);
			}
		});
		// jMenuSortAckOper
		jMenuSortAckOper.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_ACKOPER));
				table.sort();
				jMenuSortAckOper.setSelected(true);
			}
		});
		// jMenuSortCurrOper
		jMenuSortCurrOper.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_CURROPER));
				table.sort();
				jMenuSortCurrOper.setSelected(true);
			}
		});
		// jMenuSortSeverity
		jMenuSortSeverity.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_SEVERITY));
				table.sort();
				jMenuSortSeverity.setSelected(true);
			}
		});
		// jMenuSortStatus
		jMenuSortStatus.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_STATUS));
				table.sort();
				jMenuSortStatus.setSelected(true);
			}
		});
		// jMenuSortClearedBy
		jMenuSortClearedBy.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_CLEAREDBY));
				table.sort();
				jMenuSortClearedBy.setSelected(true);
			}
		});
		// jMenuSortFirst
		jMenuSortFirst.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_FIRST));
				table.sort();
				jMenuSortFirst.setSelected(true);
			}
		});
		// jMenuSortLast
		jMenuSortLast.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_LAST));
				table.sort();
				jMenuSortLast.setSelected(true);
			}
		});
		// jMenuSortCrearedAt
		jMenuSortCrearedAt.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_CREAREDAT));
				table.sort();
				jMenuSortCrearedAt.setSelected(true);
			}
		});
		// jMenuSortAckedAt
		jMenuSortAckedAt.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_ACKEDAT));
				table.sort();
				jMenuSortAckedAt.setSelected(true);
			}
		});
		// jMenuSortText
		jMenuSortText.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_TEXT));
				table.sort();
				jMenuSortText.setSelected(true);
			}
		});
		// jMenuSortTicket
		jMenuSortTicket.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_TICKET));
				table.sort();
				jMenuSortTicket.setSelected(true);
			}
		});

/*
		// jMenuSortSeverityNormal
		jMenuSortSeverityNormal.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// jMenuSortSeverityIndeterminate
		jMenuSortSeverityIndeterminate.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// jMenuSortSeverityWarning
		jMenuSortSeverityWarning.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// jMenuSortSeverityMinor
		jMenuSortSeverityMinor.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// jMenuSortSeverityMajor
		jMenuSortSeverityMajor.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// jMenuSortSeverityCritical
		jMenuSortSeverityCritical.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
			}
		});
*/
	}

	/**
	 * テーブルをソートさせ、コンポーネントをチェックします。
	 *
	 * @param comparator	Comparator
	 * @param comp			AbstractButton
	 */
	private void processSort(Comparator comparator, AbstractButton comp){
		// synchronizedさせる
		synchronized(table){
			table.setComparator(comparator);
			table.sort();
			comp.setSelected(true);
		}
	}

}
