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

// Wrapper class to the WindowsApi and HWND classes
// Simplifies creating, showing, and destroying windows
// by removing the need for extra options
public class SimpleWindow {

    // private data member to keep track of the simple window
    private HWND window;

    // simplifies the WindowsApi.createWindow() method by hiding
    // the extra options and allowing only the window name to
    // be specified
    public void create(String windowName) {
        window = WindowsApi.createWindow(windowName,
                WindowsApi.WS_OVERLAPPEDWINDOW, 400, 400, null, null);
    }

    // simplifies showing a window, since no parameters are
    // needed for this method
    public void show() {
        WindowsApi.showWindow(window, WindowsApi.SW_SHOW);
    }

    // simplifies destroying a window, no parameters are needed
    // for this method
    public void destroy() {
        WindowsApi.destroyWindow(window);
    }
}
