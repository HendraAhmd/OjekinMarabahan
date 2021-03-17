package Model;

public class Cart {

    private String pid, quantity, pname, price, store, tambahan;

    public Cart() {
    }

    public Cart(String pid, String quantity, String pname, String price, String store, String tambahan) {
        this.pid = pid;
        this.quantity = quantity;
        this.pname = pname;
        this.price = price;
        this.store = store;
        this.tambahan = tambahan;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getTambahan() {
        return tambahan;
    }

    public void setTambahan(String tambahan) {
        this.tambahan = tambahan;
    }
}

