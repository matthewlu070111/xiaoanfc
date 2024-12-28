package com.imxiaoanag.xiaoanfc.data;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record GrinderData(BlockPos pos) implements BlockPosLoader {

    public static final PacketCodec<RegistryByteBuf, GrinderData> CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, GrinderData::pos, GrinderData::new);
}
