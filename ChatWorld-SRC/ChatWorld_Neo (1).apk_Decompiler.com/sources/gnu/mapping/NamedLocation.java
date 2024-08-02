package gnu.mapping;

import java.util.Map;

public abstract class NamedLocation extends IndirectableLocation implements Map.Entry, EnvironmentKey {
    final Symbol name;
    NamedLocation next;
    final Object property;

    public boolean entered() {
        return this.next != null;
    }

    public Environment getEnvironment() {
        Environment env;
        for (NamedLocation loc = this; loc != null; loc = loc.next) {
            if (loc.name == null && (env = (Environment) loc.value) != null) {
                return env;
            }
        }
        return super.getEnvironment();
    }

    public NamedLocation(NamedLocation loc) {
        this.name = loc.name;
        this.property = loc.property;
    }

    public NamedLocation(Symbol name2, Object property2) {
        this.name = name2;
        this.property = property2;
    }

    public final Symbol getKeySymbol() {
        return this.name;
    }

    public final Object getKeyProperty() {
        return this.property;
    }

    public final boolean matches(EnvironmentKey key) {
        return Symbol.equals(key.getKeySymbol(), this.name) && key.getKeyProperty() == this.property;
    }

    public final boolean matches(Symbol symbol, Object property2) {
        return Symbol.equals(symbol, this.name) && property2 == this.property;
    }

    public final Object getKey() {
        if (this.property == null) {
            return this.name;
        }
        return this;
    }

    public boolean equals(Object x) {
        if (!(x instanceof NamedLocation)) {
            return false;
        }
        NamedLocation e2 = (NamedLocation) x;
        Symbol symbol = this.name;
        if (symbol != null ? !symbol.equals(e2.name) : e2.name != null) {
            return false;
        }
        if (this.property != e2.property) {
            return false;
        }
        Object val1 = getValue();
        Object val2 = e2.getValue();
        if (val1 == val2) {
            return true;
        }
        if (val1 == null || val2 == null) {
            return false;
        }
        return val1.equals(val2);
    }

    public int hashCode() {
        int h = this.name.hashCode() ^ System.identityHashCode(this.property);
        Object val = getValue();
        if (val != null) {
            return h ^ val.hashCode();
        }
        return h;
    }

    public synchronized Object setWithSave(Object newValue) {
        if (this.value == INDIRECT_FLUIDS) {
            return this.base.setWithSave(newValue);
        }
        ThreadLocation thloc = ThreadLocation.makeAnonymous(this.name);
        thloc.global.base = this.base;
        thloc.global.value = this.value;
        setAlias(thloc);
        NamedLocation entry = thloc.getLocation();
        entry.value = newValue;
        entry.base = null;
        return thloc.global;
    }

    public synchronized void setRestore(Object oldValue) {
        if (this.value == INDIRECT_FLUIDS) {
            this.base.setRestore(oldValue);
        } else if (oldValue instanceof Location) {
            this.value = null;
            this.base = (Location) oldValue;
        } else {
            this.value = oldValue;
            this.base = null;
        }
    }
}
