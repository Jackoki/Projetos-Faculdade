//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Habitat {
	private String nomeHab;
	private int temperatura;
	private double area;
	private String solo;

	public Habitat(){}

	public Habitat(String nomeHab, int temperatura, double area, String solo){
		this.nomeHab = nomeHab;
		this.temperatura = temperatura;
		this.area = area;
		this.solo = solo; }

	public String getNomeHab() {
		return this.nomeHab; }

	public int getTemperatura() {
		return this.temperatura; }

	public double getArea() {
		return this.area; }

	public String getSolo() {
		return this.solo; }

	public void setNomeHab(String nomeHab) {
		this.nomeHab = nomeHab; }

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura; }

	public void setArea(double area) {
		this.area = area; }

	public void setSolo(String solo) {
		this.solo = solo; }

}
