import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// A data type representing a six-sided die.
public class Die implements Comparable<Die> {
    private int value; // face value

    // Construct a die.
    public Die() {
        
    }
    
    // Roll the die.
    public void roll() {
        this.value = (int) (Math.random() * 6) + 1;
    }

    // Face value of the die.
    public int value() {
        return value;
    }

    // Does the die have the same face value as that?
    public boolean equals(Die that) {
        return this.value == that.value;
    }

    // A negative integer, zero, or positive integer depending on
    // whether this die's value is less than, equal to, or greater
    // than the that die's value.
    public int compareTo(Die that) {
        return Math.abs((this.value() - that.value()));
    }

    // A string representation of the die giving the current
    // face value.
    public String toString() {
        
    	if (this.value == 1) {
    		return "*";
    	}
    	
    	if (this.value == 2) {
    		return "*	" + "\n" + "	*";
    	}

    	if (this.value == 3) {
    		return "*	" + "\n" + " * " + "\n" + "		*";
    	}

    	if (this.value == 4) {
    		return "*	*" + "\n" + "*	*";
    	}

    	if (this.value == 5) {
    		return "*  *" + "\n" + " * " + "\n" + "*	*";
    		
    	}
    	
    	if (this.value == 6) {
    		return "* * *" + "\n	\n" + "* * *";
    	}
    	
    	return " ";
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        Die a = new Die();
        a.roll();
        while (a.value() != x) {
            a.roll();
        }
        Die b = new Die();        
        b.roll();
        while (b.value() != y) {
            b.roll();
        }
        Die c = new Die();        
        c.roll();
        while (c.value() != z) {
            c.roll();
        }
        StdOut.println(a);
        StdOut.println(a.equals(b));
        StdOut.println(b.equals(c));        
        StdOut.println(a.compareTo(b) > 0);
        StdOut.println(b.compareTo(c) > 0);        
    }
}
