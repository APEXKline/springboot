package ltd.newbee.mall.util;

import java.io.Serializable;

/**
 * @author 13
这是一个名为"Result"的类，实现了Serializable接口。它包含以下成员变量：resultCode、message和data，以及两个构造函数。
构造函数1：默认构造函数，没有参数。
构造函数2：带有两个参数的构造函数，分别是resultCode和message。通过这个构造函数可以创建一个Result对象并设置结果代码和消息。
通过实现Serializable接口，这个类的对象可以被序列化，即可以被转换为字节流或字符串表示形式，以便于存储、传输或重建。在序列化过程中，
对象的状态信息（成员变量的值）可以被保存下来，并在需要时重新创建相同的对象。这对于在分布式系统中传递对象或将对象持久化到磁盘或数据库中非常有用。
 */
//类中有泛型数据类型时，声明说也要声明出来  <T>
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int resultCode;
    private String message;
    /**
     * T代表数据类型是泛型也可以用E或其他表示
     * */
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
