package lab1;

/**
 * Model Class.
 *
 * @author Victor
 */
public class Model {


    private String first_name;
    private String last_name;
    private int height;
    private double weight;
    private boolean can_travel;
    private boolean smokes;

    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;


    /**
     * default constructor  does nothing
     */
    public Model() {

    }

    /**
     * Constructor with all its parameters
     *
     * @param first_name
     * @param last_name
     * @param height
     * @param weight
     * @param can_travel
     * @param smokes
     */
    public Model(String first_name, String last_name, int height, double weight, boolean can_travel, boolean smokes) {

        NameValidator(first_name);
        NameValidator(last_name);

        HeightValidator(height);
        WeightValidator(weight);


        setFirst_name(first_name);
        setLast_name(last_name);
        setHeight(height);
        setWeight(weight);
        setCan_travel(can_travel);
        setSmokes(smokes);

        displayModelDetails();
    }

    /**
     * Model Constructor which set automatically can_travel to true and smokes to false.
     *
     * @param first_name
     * @param last_name
     * @param height_inches
     * @param weight_pounds
     */
    public Model(String first_name, String last_name, int height_inches, double weight_pounds) {

        NameValidator(first_name);
        NameValidator(last_name);
        HeightValidator(height_inches);
        WeightValidator(weight_pounds);

        setFirst_name(first_name);
        setLast_name(last_name);
        setHeight(height_inches);
        setWeight(weight_pounds);
        setCan_travel(true);
        setSmokes(false);


    }

    /**
     * Method to get height in feet and its inches
     *
     * @return a String with the height in feet and inches or inch ( depends on if inches are more than 1 )
     */
    public String GetHeightInFeetAndInches() {
        int height = getHeight();
        double feet = height / INCHES_PER_FOOT;
        double leftover = height % INCHES_PER_FOOT;
        String HeightInFeetAndInches_str = "";
        if (leftover > 1) {

            HeightInFeetAndInches_str = feet + " feet " + leftover + " inch";
        } else {
            HeightInFeetAndInches_str = feet + " feet " + leftover + " inches";
        }


        return HeightInFeetAndInches_str;

    }

    /**
     * Method to get weight in kilograms
     *
     * @return return weight in Kg
     */
    public long GetWeightKg() {
        double weight_in_pounds = getWeight();
        double weight_in_kg = weight_in_pounds / POUNDS_PER_KG;
        long weight_in_kg_rounded = Math.round(weight_in_kg);
        return weight_in_kg_rounded;
    }

    /**
     * Print some details or characteristics  about the Model Object .
     */
    public void printDetails() {

        String travel = isCan_travel() ? "Does travel" : "Does not travel";
        String smoke = isSmokes() ? "Does smoke" : "Does not smoke";
        System.out.println("Name: " + getFirst_name() + " " + getLast_name() + "\n"
                + "Height: " + getHeight() + " inches" + "\n"
                + "Weight: " + getWeight() + " pounds" + "\n" + travel + "\n" + smoke);
    }

    /**
     * Print some details or characteristics  about the Model Object but with  some slight difference  .
     */
    public void displayModelDetails() {
        String travel = isCan_travel() ? "Yep" : "nope";
        String smoke = isSmokes() ? "Yep" : "nope";
        System.out.println("Name: " + getFirst_name() + " " + getLast_name() + "\n"
                + "Height: " + GetHeightInFeetAndInches()  + "\n"
                + "Weight: " + getWeight() + " pounds" + "\n" + "Travels: " + travel + "\n" + "Smokes: " + smoke + "\n" +
                "Hourly Rate: $" + CalculatePayDollarsPerHour());

    }

    /**
     *
     * @return it calculate pay dollar per hour adding some bonus or extras or discounting depends on each case.
     */
    public int CalculatePayDollarsPerHour() {
        int payDollarPerHour = 0;
        int tallThinBonus = 0;
        int willingToTravel = 0;
        int smokeDeduction = 0;

        if (getHeight() >= TALL_INCHES || getWeight() <= THIN_POUNDS) {
            tallThinBonus = TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }

        if (isCan_travel()) {
            willingToTravel = TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }

        if (isSmokes()) {
            smokeDeduction = SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }


        payDollarPerHour = BASE_RATE_DOLLARS_PER_HOUR + tallThinBonus + willingToTravel - smokeDeduction;

        return payDollarPerHour;
    }


    /**
     * Method to validate First and Last name.
     *
     * @param name
     */
    private void NameValidator(String name) {
        if (name.length() < 3 || name.length() > 20) {

            throw new IllegalArgumentException("First or LastName  must be 3 to 20 of length");
        }

    }

    /**
     * Method to validate height input
     *
     * @param height
     */
    private void HeightValidator(int height) {

        if (height < 24 || height > 84) {

            throw new IllegalArgumentException("height must be 24 to 84 inches");
        }

    }

    /**
     * Method to validate weight
     *
     * @param weight
     */
    private void WeightValidator(double weight) {

        if (weight < 80 || weight > 280) {

            throw new IllegalArgumentException("height must be 24 to 84 pounds");
        }
    }

    /**
     *
     * @param kilograms
     */
    public void setWeight(long kilograms) {

    }

    /**
     *
     * @param feet
     * @param inches
     */
    public void setHeight(int feet, int inches) {

    }


    /**
     * @return first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @return
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return
     */
    public boolean isCan_travel() {
        return can_travel;
    }

    /**
     * @return
     */
    public boolean isSmokes() {
        return smokes;
    }

    /**
     * @param first_name
     */
    public void setFirst_name(String first_name) {

        NameValidator(first_name);
        this.first_name = first_name;
    }

    /**
     * @param last_name
     */
    public void setLast_name(String last_name) {
        NameValidator(last_name);
        this.last_name = last_name;
    }

    /**
     * @param height
     */
    public void setHeight(int height) {
        HeightValidator(height);
        this.height = height;
    }

    /**
     * @param weight
     */
    public void setWeight(double weight) {

        WeightValidator(weight);
        this.weight = weight;
    }

    /**
     * @param can_travel
     */
    public void setCan_travel(boolean can_travel) {
        this.can_travel = can_travel;
    }

    /**
     * @param smokes
     */
    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }


}
