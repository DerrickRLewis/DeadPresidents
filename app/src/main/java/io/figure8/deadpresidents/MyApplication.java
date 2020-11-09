package io.figure8.deadpresidents;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<President> presidentList = new ArrayList<President>();
    private static int nextId = 10;

    public MyApplication() {
        fillPresidentList();
    }

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/160px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1, "Ronald Reagan", 1981, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Official_Portrait_of_President_Reagan_1981.jpg/165px-Official_Portrait_of_President_Reagan_1981.jpg");
        President p2 = new President(2, "Abraham Lincoln", 1861, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Abraham_Lincoln_O-77_matte_collodion_print.jpg/160px-Abraham_Lincoln_O-77_matte_collodion_print.jpg");
        President p3 = new President(3, "Ulysses S. Grant", 1869, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Ulysses_S_Grant_by_Brady_c1870-restored.jpg/160px-Ulysses_S_Grant_by_Brady_c1870-restored.jpg");
        President p4 = new President(4, "Theodore Roosevelt", 1901, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/President_Roosevelt_-_Pach_Bros.jpg/160px-President_Roosevelt_-_Pach_Bros.jpg");
        President p5 = new President(5, "Franklin D. Roosevelt", 1933, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/FDR_in_1933_%281%29.jpg/160px-FDR_in_1933_%281%29.jpg");
        President p6 = new President(6, "John F. Kennedy", 1961, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/John_F._Kennedy%2C_White_House_color_photo_portrait.jpg/160px-John_F._Kennedy%2C_White_House_color_photo_portrait.jpg");
        President p7 = new President(7, "Lyndon B. Johnson", 1963, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/37_Lyndon_Johnson_3x4.jpg/160px-37_Lyndon_Johnson_3x4.jpg");
        President p8 = new President(8, "Richard Nixon", 1969, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Richard_Nixon_presidential_portrait.jpg/160px-Richard_Nixon_presidential_portrait.jpg");
        President p9 = new President(9, "Dwight D. Eisenhower", 1953, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Dwight_D._Eisenhower%2C_official_photo_portrait%2C_May_29%2C_1959.jpg/160px-Dwight_D._Eisenhower%2C_official_photo_portrait%2C_May_29%2C_1959.jpg");

        presidentList.addAll(Arrays.asList(new President[]{p0,p1,p2,p3,p4,p5,p6,p7,p8,p9}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
