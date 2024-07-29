package androidx.camera.core.processing;

import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.List;

final class AutoValue_SurfaceProcessorNode_In extends SurfaceProcessorNode.In {
    private final List<SurfaceProcessorNode.OutConfig> outConfigs;
    private final SurfaceEdge surfaceEdge;

    public List<SurfaceProcessorNode.OutConfig> getOutConfigs() {
        return this.outConfigs;
    }

    public SurfaceEdge getSurfaceEdge() {
        return this.surfaceEdge;
    }

    AutoValue_SurfaceProcessorNode_In(SurfaceEdge surfaceEdge2, List<SurfaceProcessorNode.OutConfig> list) {
        if (surfaceEdge2 != null) {
            this.surfaceEdge = surfaceEdge2;
            if (list != null) {
                this.outConfigs = list;
                return;
            }
            throw new NullPointerException("Null outConfigs");
        }
        throw new NullPointerException("Null surfaceEdge");
    }

    public String toString() {
        return "In{surfaceEdge=" + this.surfaceEdge + ", outConfigs=" + this.outConfigs + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceProcessorNode.In)) {
            return false;
        }
        SurfaceProcessorNode.In in = (SurfaceProcessorNode.In) obj;
        if (!this.surfaceEdge.equals(in.getSurfaceEdge()) || !this.outConfigs.equals(in.getOutConfigs())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.surfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.outConfigs.hashCode();
    }
}
