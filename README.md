# ShootingStars

Use NASA’s public HTTP APIs to create a function which determines which
of three locations has seen the brightest shooting stars since 2017.

1.  Documentation for the API you'll be using:

      https://ssd-api.jpl.nasa.gov/doc/fireball.html

3.  Implement a function fireball() whose function signature
    looks like this (can differ slightly depending on the
    language you chose):

      Object fireball(double latitude, double longitude)

    When there is enough data to do so, the function should
    return the brightness and location for the brightest shooting 
    star seen since 2017 at the given location.

    The human eye can see a lot of the night sky, so give your latitude
    and longitude a buffer of +/- 15. For example, if you are looking
    for shooting stars at the Delphix SF Office 
         37.7937007 N,  122.4039064 W
    You would look for shooting stars within these coordinates: 
         (22.7937007   <--> 52.7937007 N,
         107.4039064 <--> 137.4039064 W)

    *Note* that Latitude and Longitude can be written in a few different
    formats. We suggest either using Signed Degrees, or Degrees plus
    Compass Direction:

    Signed Degrees:
     - Latitudes range from -90 to 90.
     - Longitudes range from -180 to 180.
     
    Degrees plus Compass Direction:
    Latitudes range from 0 to 90.
    Longitudes range from 0 to 180.
    Use N, S, E or W as either the first or last character, which
    represents a compass direction North, South, East or West.

    The brightness should be determined using the energy from each
    shooting star (a higher ‘energy’ meaning a brighter star).
    
    You can use the https://ssd-api.jpl.nasa.gov/doc/fireball.html API
    to get the information you will need to compute this.

4.  With your fireball() function, determine which of three
    locations had the brightest shooting star since
    2017. Print out the location and brightness for that star.

    Use these Office Locations to figure out which Office
    saw the brightest star since 2017 (2017-01-01 -> 2020-01-01)


    Boston -        latitude: 42.354558N, longitude:  71.054254W
    NCR -           latitude: 28.574389N, longitude:  77.312638E
    San Francisco - latitude: 37.793700N, longitude: 122.403906W
