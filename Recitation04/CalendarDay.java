package folder_sample;

public class CalendarDay {

    // Objects
    private String date;
    private String day;
    private boolean isWorkday;
    private String[] classesToday = new String[0]; // Initialize as empty array
    private int numberOfClasses = 0;

    // Constructor
    public CalendarDay(String date, String day, boolean isWorkday) {
        this.date = date;
        this.day = day;
        this.isWorkday = isWorkday;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        System.out.println("Date set to: " + date);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
        System.out.println("Day set to: " + day);
    }

    public boolean isWorkday() {
        return isWorkday;
    }

    public void setWorkday(boolean isWorkday) {
        this.isWorkday = isWorkday;
        System.out.println("Workday set to: " + isWorkday);
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    // AddClass method with exception handling
    public void addClass(String className) throws Exception {
        if (numberOfClasses >= 3) {
            throw new Exception("Maximum 3 classes allowed. Already have " + numberOfClasses + " classes.");
        }
        String[] newClasses = new String[classesToday.length + 1];
        System.arraycopy(classesToday, 0, newClasses, 0, classesToday.length);
        newClasses[newClasses.length - 1] = className;
        classesToday = newClasses;
        numberOfClasses++;
    }
    
    public void printCompleteDay() {
        System.out.println("Date: " + date);
        System.out.println("Day: " + day);
        System.out.println("Is workday: " + isWorkday);
        System.out.println("Number of classes: " + numberOfClasses);
        if (numberOfClasses > 0) {
            System.out.println("Classes:");
            for (String className : classesToday) {
                System.out.println(" - " + className);
            }
        } else {
            System.out.println("No classes scheduled.");
        }
    }

}
