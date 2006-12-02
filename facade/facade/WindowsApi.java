// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #4 (facade)
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

package facade;

/**
 * Sample of MS Windows API
 */
public class WindowsApi {
    // Window style options
    public static final int WS_BORDER = 1;
    public static final int WS_CHILD = 2;
    public static final int WS_DISABLED = 3;
    public static final int WS_OVERLAPPEDWINDOW = 4;
    public static final int WS_POPUP = 5;
    public static final int WS_VISIBLE = 6;

    // ShowWindow command options.
    public static final int SW_HIDE = 1;
    public static final int SW_MAXIMIZE = 2;
    public static final int SW_MINIMIZE = 3;
    public static final int SW_RESTORE = 4;
    public static final int SW_SHOW = 5;

    /**
     * Creates a new window handle
     */
    public static HWND createWindow(
            String windowName,
            int style,
            int width,
            int height,
            HWND parent,
            HWND menu) {
        System.out.println("Creating window '" + windowName + "'");
        return new HWND();
    }

    /**
     * Displays an already created window.
     */
    public static void showWindow(HWND window, int cmd) {
        System.out.println("Showing window");
    }

    /**
     * Destroys a window.
     */
    public static void destroyWindow(HWND window) {
        System.out.println("Destroying window");
    }
}
