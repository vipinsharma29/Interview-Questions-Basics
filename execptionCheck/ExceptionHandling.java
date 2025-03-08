package execptionCheck;

public class ExceptionHandling {

    public static void main(String[] args) throws Exception {

        try {
            System.out.println(m1());
        } catch (Exception e) {
            System.out.println();
        }

        try {
            System.out.println(m2());
        } catch (Exception e) {
            System.out.println();
        }

        try {
            System.out.println(m3());
        } catch (Exception e) {
            System.out.println();
        }

        try {
            System.out.println(m4());
        } catch (Exception e) {
            System.out.println();
        }

        try {
            System.out.println(m5());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private static Integer m5() throws Exception {
        try {
            int a = 2 / 0;
        }
        catch (Exception e) {
            System.err.println("catch");
            return -1;
        } finally {
            System.err.println("finally");
            try {
                int a = 2 / 0;
            } catch (Exception e) {
                System.err.println("catch2");
                return -2;
            } finally {
                System.err.println("finally2");
            }
        }
        return 1;
    }

    private static Integer m4() throws Exception {
        try {
            int a = 2 / 0;
        }
        catch (Exception e) {
            System.err.println("catch");
            throw new Exception(e.getMessage());
        } finally {
            System.err.println("finally");
            try {
                int a = 2 / 0;
            } catch (Exception e) {
                System.err.println("catch2");
                throw new Exception(e.getMessage() + " 2 ");
            } finally {
                System.err.println("finally2");
            }
        }
        
        return 1;
    }

    private static Integer m3() throws Exception {
        try {
            int a = 2 / 0;
        }
        catch (Exception e) {
            System.err.println("catch");
            throw new Exception(e.getMessage());
        } finally {
            System.err.println("finally");
            try {
                int a = 2 / 0;
            } catch (Exception e) {
                System.err.println("catch2");
                return -2;
            } finally {
                System.err.println("finally2");
            }
        }
        return 1;
    }

    private static Integer m2() throws Exception {
        try {
            int a = 2 / 0;
        }
        catch (Exception e) {
            System.err.println("catch");
            return -1;
        } finally {
            System.err.println("finally");
        }
        return 1;
    }

    private static Integer m1() throws Exception {
        try {
            int a = 2 / 0;
        }
        catch (Exception e) {
            System.err.println("catch");
            throw new Exception(e.getMessage());
        } finally {
            System.err.println("finally");
        }
        return 1;
    }
}
