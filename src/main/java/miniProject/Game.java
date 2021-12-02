package miniProject;

import java.util.Objects;

public class Game {
	private String title;
	private String esrbRating;
	private String platform;
	private float price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEsrbRating() {
		return esrbRating;
	}
	public void setEsrbRating(String esrbRating) {
		this.esrbRating = esrbRating;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Game [title=" + title + ", esrbRating=" + esrbRating + ", platform=" + platform + ", price=" + price
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(esrbRating, platform, price, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(esrbRating, other.esrbRating) && Objects.equals(platform, other.platform)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(title, other.title);
	}
}
