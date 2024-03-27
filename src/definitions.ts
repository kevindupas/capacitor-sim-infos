export interface SimInformationsPlugin {
  getOperatorAndNetworkType(): Promise<{ operatorName: string; networkType: string }>;
}
