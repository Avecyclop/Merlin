var username;

$(function()
{
	setupEventListeners();

	Api.getRooms(function(data)
	{
		console.log(data);
		const roomList = document.getElementById("roomList");
		data.forEach(function(room)
		{
			roomList.innerHTML += "<li id=\"roomListItem-" + room.id + "\"  data-id=\""	 + room.id + "\">" + room.name + "</li>";
		});
	});
});

function setupEventListeners()
{
	addClickEventToRoomList();
	addClickEventToCreateNewRoomButton();
	setNameInputFormBehaviour();
	setCreateNewRoomFormBehaviour();
}

function addClickEventToCreateNewRoomButton()
{
	$("#createNewRoomButton").click(function()
	{
		switchToDiv("#createNewRoomDiv");
	});

}

function addClickEventToRoomList()
{
	document.getElementById("roomList").addEventListener("click",function(e)
	{
		const roomId = $(e.target).data("id");
		joinRoom(roomId);
		console.log("User clicked room " + roomId);
	});
}

function switchToDiv(div)
{
	$(".mainDiv").hide();
	$(div).show();
}


function setNameInputFormBehaviour()
{
	$("#nameSubmitForm").submit(function(event)
	{
		submitName();
		event.preventDefault();
	});
}

function setCreateNewRoomFormBehaviour()
{
	$("#createNewRoomForm").submit(function()
	{
		const roomName = $("#newRoomInput").val();
		createNewRoom(roomName);
		event.preventDefault();
	});
}

function submitName()
{
	const username = $("#nameInput").val();
	Api.createPlayer(username, function(player)
	{
		console.log("Got callback from createplayer");
		console.log(player);
		loggedIn(player);
	});

}

function loggedIn(player)
{
	username = player.name;
	switchToDiv("#roomJoinDiv");
}

function joinRoom(roomId)
{
	Api.joinRoom(roomId, username, function()
	{
		switchToDiv("#insideRoomDiv");
		Api.getRoom(roomId, function(room)
		{
			updateRoom(room);
		});
	});
}

function createNewRoom(roomName)
{
	Api.createRoom(roomName, function(room)
	{
		joinRoom(room.id);
	});
}

function updateRoom(room)
{
	console.log("update room");
	console.log(room);
	$("#insideRoomHeader").append(" " + room.name);
}

