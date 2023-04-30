package com.example.Ecommerce.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Userr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idUser;
    private String nameUser;
    private LocalDateTime modified_atUser;
    @CreatedDate()
    private LocalDateTime created_atUser;
    private String adresseIP;
    private String adresseMAC;



    @OneToOne(mappedBy = "userr",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Useradresse userAdresse;

//============================== GETTER & SETTER ====================================

    public Userr(Long idUser) {
        this.idUser = idUser;
    }

    public String getAdresseIP() { return adresseIP; }
    public void setAdresseIP(String adresseIP) { this.adresseIP = adresseIP; }

    public String getAdresseMAC() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();

            if (mac != null) {
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
                }
            }

            return sb.toString();
        } catch (UnknownHostException | SocketException ex) {
            // Handle the exception as appropriate for your application
            ex.printStackTrace();
            return null;
        }

    }

    public void setAdresseMAC(String adresseMAC) { this.adresseMAC = adresseMAC; }
}
