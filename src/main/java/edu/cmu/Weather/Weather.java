package edu.cmu.Weather;

public class Weather {
    private WeatherService weatherService;
    private Scale unit=Scale.millimeters;

    public enum Scale {
        inches,
        millimeters
    }
    /**
     * Sets the length scale for rainfall.
     *
     * @param inches if true, sets the scale to inches; if false, sets the scale to millimeters.
     */

    // violate U5: An API must be appropriate to its audience
    // violate U6: APIs should be approachable
    // method is ambiguous in using: what kind of scale does setLengthScale(true) mean?
    public void setLengthScale(Scale unit) {
        if(unit == null){
            throw new IllegalArgumentException("Scale cannot be null");
        }
        this.unit = unit;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in the preferred scale.
     * 
     * @return the rainfall amount. If the measurement is in inches, it returns the value as is.
     *         If the measurement is not in inches, it converts the value to millimeters.
     */
    public double getRainfall() {
        double wsRainfall = weatherService.getRainfall();
        if (unit == Scale.inches) {
            return wsRainfall / 25.4;
        } else {
            return wsRainfall;
        }
    }
}
