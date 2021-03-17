package Model;

public class Ongkir {

    private String ongkirJekRide, ongkirJekSend, ongkirJekFood, confirmText;

    public Ongkir() {
    }

    public Ongkir(String ongkirJekRide, String ongkirJekSend, String ongkirJekFood, String confirmText) {
        this.ongkirJekRide = ongkirJekRide;
        this.ongkirJekSend = ongkirJekSend;
        this.ongkirJekFood = ongkirJekFood;
        this.confirmText = confirmText;
    }

    public String getOngkirJekRide() {
        return ongkirJekRide;
    }

    public void setOngkirJekRide(String ongkirJekRide) {
        this.ongkirJekRide = ongkirJekRide;
    }

    public String getOngkirJekSend() {
        return ongkirJekSend;
    }

    public void setOngkirJekSend(String ongkirJekSend) {
        this.ongkirJekSend = ongkirJekSend;
    }

    public String getOngkirJekFood() {
        return ongkirJekFood;
    }

    public void setOngkirJekFood(String ongkirJekFood) {
        this.ongkirJekFood = ongkirJekFood;
    }

    public String getConfirmText() {
        return confirmText;
    }

    public void setConfirmText(String confirmText) {
        this.confirmText = confirmText;
    }
}
