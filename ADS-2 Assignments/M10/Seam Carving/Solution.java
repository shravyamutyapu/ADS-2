import java.util.Scanner;
import java.util.Arrays;
/**
 * sol class.
 **/
final class Solution {
    /**
     * default constructor.
     **/
    private Solution() {

    }
    /**
     * printEnergies.
     * @param fileName String.
     **/
    public static void printEnergies(final String fileName) {
        Picture pic = new Picture(fileName);
        System.out.printf("image is %d pixels wide by %d pixels high.\n",
         pic.width(), pic.height());

        SeamCarver sc = new SeamCarver(pic);

        System.out.printf("Printing energy calculated for each pixel.\n");

        for (int row = 0; row < sc.height(); row++) {
            for (int col = 0; col < sc.width(); col++) {
                System.out.printf("%9.0f ", sc.energy(col, row));
            }
            System.out.println();
        }
    }
    /**
     * printSeam method.
     * @param carver seamCarver.
     * @param seam int[].
     * @param direction boolean.
     */
    public static void printSeam(final SeamCarver carver,
     final int[] seam, final boolean direction) {
        double totalSeamEnergy = 0.0;
        boolean t = true;
        boolean f = false;

        for (int row = 0; row < carver.height(); row++) {
            for (int col = 0; col < carver.width(); col++) {
                double energy = carver.energy(col, row);
                String marker = " ";
                if ((direction == t && row == seam[col])) {
                    marker = "*";
                    totalSeamEnergy += energy;
                } else if ((direction == f   && col == seam[row])) {
                    marker = "*";
                    totalSeamEnergy += energy;
                }
                System.out.printf("%7.2f%s ", energy, marker);
            }
            System.out.println();
        }
        System.out.printf("Total energy = %f\n", totalSeamEnergy);
        System.out.println();
        System.out.println();
    }
/**
 * main method.
 * @param args args.
 */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();
        SeamCarver seam = null;
        try {
            switch (cases) {
            case "width":
                while (scan.hasNextLine()) {
                    String file = scan.nextLine();
                    seam = new SeamCarver(new Picture(
                        "/Files/" + file));
                    System.out.println(seam.width());
                }
                break;

            case "height":
                while (scan.hasNextLine()) {
                    String file = scan.nextLine();
                    seam = new SeamCarver(
                        new Picture("/Files/" + file));
                    System.out.println(seam.height());
                }
                break;

            case "energy":
                while (scan.hasNextLine()) {
                    String file = scan.nextLine();
                    printEnergies("/Files/" + file);
                }
                break;

            case "findVerticalSeam":
                while (scan.hasNextLine()) {
                    String file = scan.nextLine();
                    seam = new SeamCarver(new Picture("/Files/" + file));
                    System.out.println(Arrays.toString(
                        seam.findVerticalSeam()));
                }
                break;

              case "findHorizontalSeam":
                while (scan.hasNextLine()) {
                    String file = scan.nextLine();
                    seam = new SeamCarver(new Picture("/Files/" + file));
                    System.out.println(Arrays.toString(
                        seam.findHorizontalSeam()));
                }
                break;

            case "removeVerticalSeam":
                while (scan.hasNextLine()) {
                    String file = scan.nextLine();
                    seam = new SeamCarver(new Picture("/Files/" + file));
                    int[] verticalSeam = seam.findVerticalSeam();
                    seam.removeVerticalSeam(verticalSeam);
                    printSeam(seam, verticalSeam, false);
                }
                break;

            case "removeHorizontalSeam":
             while (scan.hasNextLine()) {
                    String file = scan.nextLine();
                    seam = new SeamCarver(new Picture("/Files/" + file));
                    seam.removeHorizontalSeam(
                        seam.findHorizontalSeam());
                    int[] horizontalSeam = seam.findHorizontalSeam();
                    seam.removeHorizontalSeam(horizontalSeam);
                    printSeam(seam, horizontalSeam, true);
                }
                break;

            case "removeHorizontalSeam removeVerticalSeam":
                while (scan.hasNextLine()) {
                    String file = scan.nextLine();
                    seam = new SeamCarver(new Picture("/Files/" + file));
                    int[] horizontalSeam = seam.findHorizontalSeam();
                    seam.removeHorizontalSeam(horizontalSeam);
                    int[] verticalSeam = seam.findVerticalSeam();
                    seam.removeVerticalSeam(verticalSeam);
                    printEnergies("/Files/" + file);
                }
                break;

            default:
                seam = new SeamCarver(null);
                break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}



