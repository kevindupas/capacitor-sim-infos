package com.kevindupas.capacitor.siminfos;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SimInformations")
public class SimInformationsPlugin extends Plugin {

    @PluginMethod
    public void getOperatorAndNetworkType(PluginCall call) {
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        JSObject ret = new JSObject();

        if (telephonyManager == null) {
            call.reject("Unable to access telephony service");
            return;
        }

        // Récupérer le nom de l'opérateur téléphonique
        String operatorName = telephonyManager.getNetworkOperatorName();
        // Simplification pour l'exemple. Vous devriez adapter selon vos besoins
        String networkType = "Unknown";
        int networkTypeCode = telephonyManager.getNetworkType();
        switch (networkTypeCode) {
            // Exemple, vérifiez la documentation Android pour plus de types
            case TelephonyManager.NETWORK_TYPE_GSM:
                networkType = "2G";
                break;
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                networkType = "3G";
                break;
            case TelephonyManager.NETWORK_TYPE_LTE:
                networkType = "4G";
                break;
            // Ajoutez d'autres cas au besoin
        }

        ret.put("operatorName", operatorName);
        ret.put("networkType", networkType);

        call.resolve(ret);
    }
}
