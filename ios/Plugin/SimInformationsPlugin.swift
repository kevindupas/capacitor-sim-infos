import Foundation
import Capacitor
import CoreTelephony

@objc(SimInformationsPlugin)
public class SimInformationsPlugin: CAPPlugin {
    @objc func getOperatorAndNetworkType(_ call: CAPPluginCall) {
        let networkInfo = CTTelephonyNetworkInfo()
        let carrier = networkInfo.subscriberCellularProvider
        let operatorName = carrier?.carrierName ?? "Unknown"

        // iOS ne fournit pas directement le type de réseau cellulaire (2G/3G/4G)
        // Vous pouvez tenter d'utiliser les indicateurs de l'API Network pour déduire cela, mais ce sera limité
        let networkType = "Unknown" // Placeholder pour cette démo

        call.resolve([
            "operatorName": operatorName,
            "networkType": networkType
        ])
    }
}
