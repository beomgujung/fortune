<!DOCTYPE html>
<html>
  <head>
    <style>
       #map {
        height: 400px;
        width: 20%;
       }
    </style>
  </head>
  <body>
  
    <div id="map"></div>
    <script>
      function initMap() {
        var uluru = {lat: -25.363, lng: 131.044};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBpbZnKuX4GtshR51yxlQrzTZyVteemGn0&callback=initMap">
    </script>
  </body>
</html>