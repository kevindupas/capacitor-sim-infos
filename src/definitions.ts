export interface SimInformationsPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
