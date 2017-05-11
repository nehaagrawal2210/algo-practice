package treePractice;

/**
 * Created by neha on 2/27/2017.
 */
public class ConnectedNode {
    ConnectedNode lchild,rchild,nextRight;
    int data;

    public ConnectedNode(int data) {
        this.data = data;
        lchild=rchild=nextRight=null;
    }

    public ConnectedNode getLchild() {
        return lchild;
    }

    public void setLchild(ConnectedNode lchild) {
        this.lchild = lchild;
    }

    public ConnectedNode getRchild() {
        return rchild;
    }

    public void setRchild(ConnectedNode rchild) {
        this.rchild = rchild;
    }

    public ConnectedNode getNextRight() {
        return nextRight;
    }

    public void setNextRight(ConnectedNode nextRight) {
        this.nextRight = nextRight;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
