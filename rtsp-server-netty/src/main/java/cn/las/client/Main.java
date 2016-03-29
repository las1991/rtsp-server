package cn.las.client;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/22
 */
public class Main {
    /**
     ECF5E96A81A12FCA6701FF1FCC9F4B31
     FFC47B3CE72E275DD09C32B1AC4A9E72
     C0E888043DFDF85941E10C885FB587D3
     2828CD00B6061FD6B794B4EB4B7B1C0E
     870D3D260ED919FAF1FEA357FD16D038
     4FE2A3AE23D4C959419186930DC9CE98
     B583898C8EE52B6BD87019D0ABED7D6F
     140A4524FC57C21DA0768EBEAB4AA392
     21098A18E5AA249CD0382107EA57CD7D
     7947B6B48864E301AC3064E426F33403
     550CB12DDD577729E78E9334D416234A
     7136C7D76F5EE09DD1DA564D02EA56F9
     D7C14B4864069A1EDC61D3B078AAEFBD
     6F59F13B3DF6508B0B07EF5B6436E6D7
     91B86EE0765A4D49935FA1A0548CD240
     5B5C7903DE182ABDA4172F5628743C16
     C0FDC947EC72040A496D317CE8FBA854
     CADB3DC52D3A14170503EE0F9645326F
     */
    public static void main(String[] args) {
        String url = "rtsp://54.223.242.201:554/1.sdp";
        try {
            AbstractClient client = new ClientPush(url);
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
