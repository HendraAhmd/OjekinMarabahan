package Model;

public class AdminOrders {

    private String nama_pemesan, alamat_pengantaran, tambahan_pesanan, date, time, status;

    public AdminOrders() {
    }

    public AdminOrders(String nama_pemesan, String alamat_pengantaran, String tambahan_pesanan, String date, String time, String status) {
        this.nama_pemesan = nama_pemesan;
        this.alamat_pengantaran = alamat_pengantaran;
        this.tambahan_pesanan = tambahan_pesanan;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public String getNama_pemesan() {
        return nama_pemesan;
    }

    public void setNama_pemesan(String nama_pemesan) {
        this.nama_pemesan = nama_pemesan;
    }

    public String getAlamat_pengantaran() {
        return alamat_pengantaran;
    }

    public void setAlamat_pengantaran(String alamat_pengantaran) {
        this.alamat_pengantaran = alamat_pengantaran;
    }

    public String getTambahan_pesanan() {
        return tambahan_pesanan;
    }

    public void setTambahan_pesanan(String tambahan_pesanan) {
        this.tambahan_pesanan = tambahan_pesanan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

