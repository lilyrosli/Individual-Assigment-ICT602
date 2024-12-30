package com.example.assignment1;




import android.content.Context;
import android.content.SharedPreferences;




public class ThemeUtil {
   private static final String PREFS_NAME = "theme_prefs";
   private static final String THEME_KEY = "theme";




   public static void setTheme(Context context, int themeId) {
       // Save the selected theme ID in shared preferences
       SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
       editor.putInt(THEME_KEY, themeId);
       editor.apply();
   }




   public static int getThemeId(Context context) {
       // Retrieve the saved theme ID or default to a green theme if not set
       return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getInt(THEME_KEY, R.style.Theme_Green);  // Default to green
   }
}
