/**
 * ソート用Comparator生成クラス.
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import java.util.*;

public class AlertComparatorFactory{

/* -----------------------------------------------------------------------------
 ソート定義
----------------------------------------------------------------------------- */
	/** Sort AlertId */
	public static final int SORT_ALERTID = 1;
	/** Sort AlertDef */
	public static final int SORT_ALERTDEF = 2;
	/** Sort ObjectId */
	public static final int SORT_OBJECTID = 3;
	/** Sort ObjectClass */
	public static final int SORT_OBJECTCLASS = 4;
	/** Sort Manager */
	public static final int SORT_MANAGER = 5;
	/** Sort ManagerClass */
	public static final int SORT_MANAGERCLASS = 6;
	/** Sort Count */
	public static final int SORT_COUNT = 7;
	/** Sort AckOper */
	public static final int SORT_ACKOPER = 8;
	/** Sort CurrOper */
	public static final int SORT_CURROPER = 9;
	/** Sort Severity */
	public static final int SORT_SEVERITY = 10;
	/** Sort Status */
	public static final int SORT_STATUS = 11;
	/** Sort ClearedBy */
	public static final int SORT_CLEAREDBY = 12;
	/** Sort First */
	public static final int SORT_FIRST = 13;
	/** Sort Last */
	public static final int SORT_LAST = 14;
	/** Sort CrearedAt */
	public static final int SORT_CREAREDAT = 15;
	/** Sort AckedAt */
	public static final int SORT_ACKEDAT = 16;
	/** Sort Text */
	public static final int SORT_TEXT = 17;
	/** Sort Ticket */
	public static final int SORT_TICKET = 18;

	/** Sort Severity Normal */
//	public static final int SORT_SEVERITY_NORMAL = ;
	/** Sort Severity Indeterminate */
//	public static final int SORT_SEVERITY_INDETERMINATE = ;
	/** Sort Severity Warning */
//	public static final int SORT_SEVERITY_WARNING = ;
	/** Sort Severity Minor */
//	public static final int SORT_SEVERITY_MINOR = ;
	/** Sort Severity Major */
//	public static final int SORT_SEVERITY_MAJOR = ;
	/** Sort Severity Critical */
//	public static final int SORT_SEVERITY_CRITICAL = ;

/* -----------------------------------------------------------------------------
 Comparator定義
----------------------------------------------------------------------------- */
	/**
	 * Sort AlertId
	 *
	 */
	class ComparatorOfAlertId implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			Integer s1 = new Integer(((SeverityColor)obj1[0]).toString());
			Integer s2 = new Integer(((SeverityColor)obj2[0]).toString());

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort AlertDef
	 *
	 */
	class ComparatorOfAlertDef implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[1]).toString();
			String s2 = ((SeverityColor)obj2[1]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort ObjectId
	 *
	 */
	class ComparatorOfObjectId implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[2]).toString();
			String s2 = ((SeverityColor)obj2[2]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort ObjectClass
	 *
	 */
	class ComparatorOfObjectClass implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[3]).toString();
			String s2 = ((SeverityColor)obj2[3]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort Manager
	 *
	 */
	class ComparatorOfManager implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[4]).toString();
			String s2 = ((SeverityColor)obj2[4]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort ManagerClass
	 *
	 */
	class ComparatorOfManagerClass implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[5]).toString();
			String s2 = ((SeverityColor)obj2[5]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort Count
	 *
	 */
	class ComparatorOfCount implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			Integer s1 = new Integer(((SeverityColor)obj1[6]).toString());
			Integer s2 = new Integer(((SeverityColor)obj2[6]).toString());

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort AckOper
	 *
	 */
	class ComparatorOfAckOper implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[7]).toString();
			String s2 = ((SeverityColor)obj2[7]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort CurrOper
	 *
	 */
	class ComparatorOfCurrOper implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[8]).toString();
			String s2 = ((SeverityColor)obj2[8]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort Severity
	 *
	 */
	class ComparatorOfSeverity implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[9]).toString();
			String s2 = ((SeverityColor)obj2[9]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort Status
	 *
	 */
	class ComparatorOfStatus implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[10]).toString();
			String s2 = ((SeverityColor)obj2[10]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort ClearedBy
	 *
	 */
	class ComparatorOfClearedBy implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[11]).toString();
			String s2 = ((SeverityColor)obj2[11]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort First
	 *
	 */
	class ComparatorOfFirst implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			Integer s1 = new Integer(((SeverityColor)obj1[12]).toString());
			Integer s2 = new Integer(((SeverityColor)obj2[12]).toString());

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort Last
	 *
	 */
	class ComparatorOfLast implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			Integer s1 = new Integer(((SeverityColor)obj1[13]).toString());
			Integer s2 = new Integer(((SeverityColor)obj2[13]).toString());

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort CrearedAt
	 *
	 */
	class ComparatorOfCrearedAt implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			Integer s1 = new Integer(((SeverityColor)obj1[14]).toString());
			Integer s2 = new Integer(((SeverityColor)obj2[14]).toString());

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort AckedAt
	 *
	 */
	class ComparatorOfAckedAt implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			Integer s1 = new Integer(((SeverityColor)obj1[15]).toString());
			Integer s2 = new Integer(((SeverityColor)obj2[15]).toString());

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort Text
	 *
	 */
	class ComparatorOfText implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[16]).toString();
			String s2 = ((SeverityColor)obj2[16]).toString();

			return s1.compareTo(s2);
		}
	}

	/**
	 * Sort Ticket
	 *
	 */
	class ComparatorOfTicket implements Comparator {
		/**
		 * Comparatorの実装
		 *
		 */
		public int compare(Object o1, Object o2) {
			Object[] obj1 = (Object[])o1;
			Object[] obj2 = (Object[])o2;

			String s1 = ((SeverityColor)obj1[17]).toString();
			String s2 = ((SeverityColor)obj2[17]).toString();

			return s1.compareTo(s2);
		}
	}


/* -----------------------------------------------------------------------------
 Comparator生成
----------------------------------------------------------------------------- */
	/**
	 * ソート用Comparator生成
	 *
	 * @param	option		ソート条件
	 * @return				Comparator
	 */
	public static Comparator create(int option){
		switch(option){
			case SORT_ALERTID:
				return new AlertComparatorFactory().new ComparatorOfAlertId();
			case SORT_ALERTDEF:
				return new AlertComparatorFactory().new ComparatorOfAlertDef();
			case SORT_OBJECTID:
				return new AlertComparatorFactory().new ComparatorOfObjectId();
			case SORT_OBJECTCLASS:
				return new AlertComparatorFactory().new ComparatorOfObjectClass();
			case SORT_MANAGER:
				return new AlertComparatorFactory().new ComparatorOfManager();
			case SORT_MANAGERCLASS:
				return new AlertComparatorFactory().new ComparatorOfManagerClass();
			case SORT_COUNT:
				return new AlertComparatorFactory().new ComparatorOfCount();
			case SORT_ACKOPER:
				return new AlertComparatorFactory().new ComparatorOfAckOper();
			case SORT_CURROPER:
				return new AlertComparatorFactory().new ComparatorOfCurrOper();
			case SORT_SEVERITY:
				return new AlertComparatorFactory().new ComparatorOfSeverity();
			case SORT_STATUS:
				return new AlertComparatorFactory().new ComparatorOfStatus();
			case SORT_CLEAREDBY:
				return new AlertComparatorFactory().new ComparatorOfClearedBy();
			case SORT_FIRST:
				return new AlertComparatorFactory().new ComparatorOfFirst();
			case SORT_LAST:
				return new AlertComparatorFactory().new ComparatorOfLast();
			case SORT_CREAREDAT:
				return new AlertComparatorFactory().new ComparatorOfCrearedAt();
			case SORT_ACKEDAT:
				return new AlertComparatorFactory().new ComparatorOfAckedAt();
			case SORT_TEXT:
				return new AlertComparatorFactory().new ComparatorOfText();
			case SORT_TICKET:
				return new AlertComparatorFactory().new ComparatorOfTicket();
			default:
				return new AlertComparatorFactory().new ComparatorOfAlertId();
		}
	}

}
