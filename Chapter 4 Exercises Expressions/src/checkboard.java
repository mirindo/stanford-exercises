import acm.program.*;
import acm.graphics.*;


public class checkboard extends GraphicsProgram {
	/* The number of days in the month */
    private static final int DAYS_IN_MONTH = 31;
    /* The day of the week on which the month starts */
    /* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) */
    private static final int DAY_MONTH_STARTS = 5;
    /* The width in pixels of a day on the calendar */
    private static final int DAY_WIDTH = 40;
    /* The height in pixels of a day on the calendar */
    private static final int DAY_HEIGHT = 30;
	
	public void run() {
//		for (int i = 0; i < 400; i+=50) {
//			for (int x = 0; x < 400; x+=50) {
//				add(new GRect(1 * i, 1 * x, 50, 50));
//				if (((x % 100 == 50) && !(i % 100 == 50)) || ((!(x % 100 == 50) && (i % 100 == 50)))) {
//					add(new GOval((1 * i) + 5, (1 * x) + 5, 40, 40));
//				}
//			}
//			
//		}
		int rowsInCalendar = 5;
		if ((DAYS_IN_MONTH >= 31) && (DAY_MONTH_STARTS > 4)) {
			rowsInCalendar = 6;
		} else if ((DAYS_IN_MONTH >= 30) && (DAY_MONTH_STARTS > 5)) {
			rowsInCalendar = 6;
		} else if ((DAYS_IN_MONTH >= 28) && (DAY_MONTH_STARTS > 6)) {
			rowsInCalendar = 4;
		}
		
		
		int startColumnInCalendar = DAY_MONTH_STARTS;
		int totalRowWidth = DAY_WIDTH * 7;
		int totalRowsHeight = DAY_HEIGHT * rowsInCalendar;
		
		for (int  y = 0; y < totalRowsHeight; y += DAY_HEIGHT) {
			for (int x = 0; x < totalRowWidth; x += DAY_WIDTH) {
				
				add(new GRect(1 * x, 1 * y, DAY_WIDTH, DAY_HEIGHT));
				
				int dateInCalendar = (x / DAY_WIDTH) + ((y / 30) * 7) - 6;
				int whereDateAppearX = 1 * x;
				int whereDateAppearY = 1 * y;
				
				if (dateInCalendar <= DAYS_IN_MONTH)  {
					switch (DAY_MONTH_STARTS) {
					case 0:
						whereDateAppearX += 0;
						if (whereDateAppearX > 241) {
							whereDateAppearX = (1 * x) - 280;
							whereDateAppearY = (1 * y) + 30;
						}
						break;
					case 1:
						whereDateAppearX += 40;
						if (whereDateAppearX > 241) {
							whereDateAppearX = (1 * x) - 240;
							whereDateAppearY = (1 * y) + 30;
						}
						break;
					case 2:
						whereDateAppearX += 80;
						if (whereDateAppearX > 241) {
							whereDateAppearX = (1 * x) - 200;
							whereDateAppearY = (1 * y) + 30;
						}
						break;
					case 3:
						whereDateAppearX += 120;
						if (whereDateAppearX > 241) {
							whereDateAppearX = (1 * x) - 160;
							whereDateAppearY = (1 * y) + 30;
						}
						break;
					case 4:
						whereDateAppearX += 160;
						if (whereDateAppearX > 241) {
							whereDateAppearX = (1 * x) - 120;
							whereDateAppearY = (1 * y) + 30;
						}
						break;
					case 5:
						whereDateAppearX += 200;
						if (whereDateAppearX > 241) {
							whereDateAppearX = (1 * x) - 80;
							whereDateAppearY = (1 * y) + 30;
						}
						break;
					case 6:
						whereDateAppearX += 240;
						if (whereDateAppearX > 241) {
							whereDateAppearX = (1 * x) - 40;
							whereDateAppearY = (1 * y) + 30;
						}
						break;
					default: 
						break;
					}
					if (dateInCalendar > 0) {
						add(new GLabel(dateInCalendar + "", whereDateAppearX, whereDateAppearY));
					}
				}
				
			}
		}
		
		
		
		
	}
	
	

}