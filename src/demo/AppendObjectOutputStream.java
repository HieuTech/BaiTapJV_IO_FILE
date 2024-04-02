package demo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendObjectOutputStream extends ObjectOutputStream {

    public AppendObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }


    @Override
    protected void writeStreamHeader() throws IOException {
//        super.writeStreamHeader();
       //**
        // writeStreamHeader sẽ ghi đè Header, làm mất dữ liệu cũ
        //
        //
        // /
//        reset();
        // xóa trạng thái đệm của luồng, ko có dữ liệu bị ghi đè lên tiêu đề của luồng.
    }
}
