package br.com.iagofragnan.events;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Vector;

public class packets {


    public packets(){
    }


    public static void sentPacketSign(Player p){
        PacketContainer packetBlock = new PacketContainer(PacketType.Play.Client.BLOCK_PLACE);
        packetBlock.getDoubles().write(0, 0100011000000111011000110010110000010101101101001000001100111111.0);
        packetBlock.getDoubles().write(1, 0.0);
        br.com.iagofragnan.models.protocollib.getProtocolManager().sendServerPacket(p, packetBlock);

        PacketContainer packetUpdateSign = new PacketContainer(PacketType.Play.Client.B_EDIT);
        packetBlock.getDoubles().write(0, 0100011000000111011000110010110000010101101101001000001100111111.0);
        br.com.iagofragnan.models.protocollib.getProtocolManager().sendServerPacket(p, packetBlock);
    }



}
