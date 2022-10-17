package connect.stellantis.car.trip.report;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MobileMessenger {
    public String m_url;
    public String m_chatID;
    public String m_token;

    public MobileMessenger() {
        m_url = new String(CarTripConstants.telegramBotUrl);
        m_chatID = new String(CarTripConstants.telegramBotChatID);
        m_token = new String(CarTripConstants.telegramBotToken);
    }

    public void sendMessage(String message) {
        String fullUrl = String.format(m_url, m_token, m_chatID, message);

        try {
            URL url = new URL(fullUrl);
            URLConnection conn = url.openConnection();
            new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
