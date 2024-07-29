package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.processing.Edge;

final class AutoValue_ProcessingNode_In extends ProcessingNode.In {
    private final Edge<ProcessingNode.InputPacket> edge;
    private final int inputFormat;
    private final int outputFormat;
    private final Edge<ProcessingNode.InputPacket> postviewEdge;

    /* access modifiers changed from: package-private */
    public Edge<ProcessingNode.InputPacket> getEdge() {
        return this.edge;
    }

    /* access modifiers changed from: package-private */
    public int getInputFormat() {
        return this.inputFormat;
    }

    /* access modifiers changed from: package-private */
    public int getOutputFormat() {
        return this.outputFormat;
    }

    /* access modifiers changed from: package-private */
    public Edge<ProcessingNode.InputPacket> getPostviewEdge() {
        return this.postviewEdge;
    }

    AutoValue_ProcessingNode_In(Edge<ProcessingNode.InputPacket> edge2, Edge<ProcessingNode.InputPacket> edge3, int i, int i2) {
        if (edge2 != null) {
            this.edge = edge2;
            if (edge3 != null) {
                this.postviewEdge = edge3;
                this.inputFormat = i;
                this.outputFormat = i2;
                return;
            }
            throw new NullPointerException("Null postviewEdge");
        }
        throw new NullPointerException("Null edge");
    }

    public String toString() {
        return "In{edge=" + this.edge + ", postviewEdge=" + this.postviewEdge + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProcessingNode.In)) {
            return false;
        }
        ProcessingNode.In in = (ProcessingNode.In) obj;
        if (!this.edge.equals(in.getEdge()) || !this.postviewEdge.equals(in.getPostviewEdge()) || this.inputFormat != in.getInputFormat() || this.outputFormat != in.getOutputFormat()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.edge.hashCode() ^ 1000003) * 1000003) ^ this.postviewEdge.hashCode()) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat;
    }
}
