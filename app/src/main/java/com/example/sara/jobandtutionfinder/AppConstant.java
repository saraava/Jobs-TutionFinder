package com.example.sara.jobandtutionfinder;

<<<<<<< HEAD
=======
import android.app.AlertDialog;
>>>>>>> origin/master
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
<<<<<<< HEAD
import android.support.v7.app.AlertDialog;
public class AppConstant {
    public static void showAlertMessage(Context context, String message) {


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }
=======

public class AppConstant {   public static void showAlertMessage(Context context, String message) {


    AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

    alertDialog.setMessage(message);
    alertDialog.setPositiveButton("OK",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
    alertDialog.show();
}
>>>>>>> origin/master

    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        Intent i = manager.getLaunchIntentForPackage(packageName);
        if (i == null) {
            return false;
        }
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        context.startActivity(i);
        return true;
    }
}
