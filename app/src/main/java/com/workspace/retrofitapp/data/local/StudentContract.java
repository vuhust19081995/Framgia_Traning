package com.workspace.retrofitapp.data.local;

import android.provider.BaseColumns;

/**
 * Created by workspace on 05/09/2017.
 */

public class StudentContract {
    public StudentContract() {
    }

    public static class StudentEntry implements BaseColumns{
        public static final String TABLE_NAME = "tbl_student";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
    }
}
