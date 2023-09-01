package methods;

// CS 374 F23 - 
// Rubric - 3 points for turning in something that runs, + 1 pt for each method successfully implemented
// maximum = 10 points
class Method {
    public static void main(String[] args)
    {
        int intArg = 1;
        System.out.println("before invoking intMethod: intArg = " + intArg);
        intMethod(intArg);
        System.out.println("after return from intMethod: intArg = " + intArg );

        // define and set floatArg = 2, print it out, and invoke floatMethod(flost floatArg), then print out floatArg
        float floatArg = 2;
        System.out.println("before invoking floatMethod: floatArg = " + floatArg);
        floatMethod(floatArg);
        System.out.println("after return from floatMethod: floatArg = " + floatArg );

        // repeat for doubleArg = 3, doubleMethod(double doubleArg)
        double doubleArg = 3;
        System.out.println("before invoking doubleMethod: doubleArg = " + doubleArg);
        doubleMethod(doubleArg);
        System.out.println("after return from doubleMethod: doubleArg = " + doubleArg );

        // repeat for byteArg = 4
        byte byteArg = 4;
        System.out.println("before invoking byteMethod: byteArg = " + byteArg);
        byteMethod(byteArg);
        System.out.println("after return from byteMethod: byteArg = " + byteArg );

        // repeat for StringArg = "5"
        String StringArg = "5";
        System.out.println("before invoking StringMethod: StringArg = " + StringArg);
        StringMethod(StringArg);
        System.out.println("after return from StringMethod: StringArg = " + StringArg );

        // repeat for int[] intarrayArg[0] = 6
        int[] intarrayArg = new int[1];
        intarrayArg[0] = 6;
        System.out.println("before invoking intarrayMethod: intarrayArg[0] = " + intarrayArg[0]);
        intarrayMethod(intarrayArg);
        System.out.println("after return from intarrayMethod: intarrayArg[0] = " + intarrayArg[0] );

        // repeat for class SimpleClass.intMember = 7
        SimpleClass simpleclassArg = new SimpleClass();
        simpleclassArg.intMember = 7;
        System.out.println("before invoking classMethod: simpleclassArg.intMember = " + simpleclassArg.intMember);
        classMethod(simpleclassArg);
        System.out.println("after return from classMethod: simpleclassArg.intMember = " + simpleclassArg.intMember );

    }

    // intMethod: add 100 to intArg
    static void intMethod(int iarg)
    {
    iarg = iarg + 100;
    System.out.println("inside intMethod: iarg = " + iarg);
    }

    // add floatMethod(float floatArg) here
    public static void floatMethod(float floatArg){
        floatArg = floatArg + 100;
        System.out.println("inside floatMethod: floatArg = " + floatArg);
    }

    // add doubleMethod(double doubleArg) here
    public static void doubleMethod(double doubleArg){
        doubleArg = doubleArg + 100;
        System.out.println("inside doubleMethod: doubleArg = " + doubleArg);
    }

    // add byteMethod(byte byteArg) here
    public static void byteMethod(byte byteArg){
        byteArg = (byte) (byteArg + 100);
        System.out.println("inside byteMethod: byteArg = " + byteArg);
    }

    // add charMethod(char charArg) here
    public static void charMethod(char charArg){
        charArg = (char) (charArg + 100);
        System.out.println("inside charMethod: charArg = " + charArg);
    }

    // add StringMethod(String StringArg) here
    public static void StringMethod(String StringArg){
        StringArg = StringArg + 100;
        System.out.println("inside StringMethod: StringArg = " + StringArg);
    }

    // add intarrayMethod(int[] intarrayArg) here
    public static void intarrayMethod(int[] intarrayArg){
        intarrayArg[0] = intarrayArg[0] + 100;
        System.out.println("inside intarrayMethod: intarrayArg[0] = " + intarrayArg[0]);
    }

    // add classMethod(SimpleClass simpleclassArg) here
    public static void classMethod(SimpleClass simpleclassArg){
        simpleclassArg.intMember = simpleclassArg.intMember + 100;
        System.out.println("inside classMethod: simpleclassArg.intMember = " + simpleclassArg.intMember);
    }
}

class SimpleClass {
    int intMember;
}