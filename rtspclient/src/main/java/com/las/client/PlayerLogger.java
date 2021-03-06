package com.las.client;

import com.las.rtp.FramingRtpPacket;
import com.las.rtp.InterleavedRtpPacket;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;

public class PlayerLogger implements Observer {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final Player player;

    public PlayerLogger(Player player) {
        this.player = player;
        player.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Player && arg instanceof FramingRtpPacket) {
            FramingRtpPacket rtpPacket = (FramingRtpPacket) arg;
            logger.trace("{}", rtpPacket);
        } else if (o instanceof Player && arg instanceof InterleavedRtpPacket) {
            InterleavedRtpPacket rtpPacket = (InterleavedRtpPacket) arg;
            ByteBuf byteBuf = rtpPacket.content();
            byte octet = byteBuf.readByte();
            int nal_unit_type = octet & 0x1F;

            logger.info("{} nal type :{}", rtpPacket.header(), nal_unit_type);
        }
    }
}
