var Api = (function()
{
    var pub = {},
    //Private property
    greyFloorTile = null;

    //Public property
    //pub.ingredient = "Bacon Strips";

    //Public method
    pub.createPlayer = function(name, callback)
    {
		$.post("api/web/players", name, function(data)
		{
			callback(data);
		});
    }

    pub.getRooms = function(callback)
    {
    	$.getJSON("api/web/room", function(data)
    	{
    		callback(data);
    	});
    };

    pub.createRoom = function(roomName, callback)
    {
    	$.post("api/web/room", roomName, function(data)
    	{
    		callback(data);
    	});
    }

	pub.joinRoom = function(roomId, username, callback)
	{
		$.post("api/web/room/" + roomId + "/player", username, function(data)
		{
			callback();
		});
	};

	pub.getRoom = function(roomId, callback)
	{
		$.getJSON("api/web/room/" + roomId, function(data)
		{
			callback(data);
		});
	};

    //Private method
    /*
    function privateWay() {
        console.log("private method");
    }
	*/
    //Return just the public parts
    return pub;

}());