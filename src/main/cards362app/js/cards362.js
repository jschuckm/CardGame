
var cards362 = (function() {
	var opt = {
		table: '#card-table',
		rotatablePlane: '#rotatable-plane',
		fixedPlane: '#fixed-plane',
		cardsUrl: 'js/3rdparty/einaregilsson-cards-js/img/cards.png',
		playerRotation: 0
	};
	var items = {};

	function init(options) {
		if (options) {
			for (var i in options) {
				if (opt.hasOwnProperty(i)) {
					opt[i] = options[i];
				}
			}
		}
		cards.init({table: opt.table, cardsUrl: opt.cardsUrl});
	}

	cards.Card.prototype.setFixed = function(fixed) {
		if (fixed) {
			this.el.detach().appendTo($(opt.fixedPlane))
		} else {
			this.el.detach().appendTo($(opt.rotatablePlane))
		}
	};

	cards.Card.prototype.setUpright = function(upright) {
		if (upright) {
			this.el.classList.add('player-upright')
		} else {
			this.el.classList.remove('player-upright')
		}
	};

	cards.Card.prototype.setVisible = function(visible) {
		if (visible) {
			this.el.show();
		} else {
			this.el.hide();
		}
	};

	cards.Container.prototype.setFixed = function(fixed) {

	};

	cards.Container.prototype.setUpright = function(upright) {

	};

	cards.Container.prototype.setVisible = function(visible) {

	};

	cards.Deck.prototype.setFixed = setFixed;
	cards.Deck.prototype.setUpright = setUpright;
	cards.Deck.prototype.setVisible = setVisible;
	cards.Hand.prototype.setFixed = setFixed;
	cards.Hand.prototype.setUpright = setUpright;
	cards.Hand.prototype.setVisible = setVisible;
	cards.Pile.prototype.setFixed = setFixed;
	cards.Pile.prototype.setUpright = setUpright;
	cards.Pile.prototype.setVisible = setVisible;

	function createCard(id, suit, rank) {
		card = new cards.Card(suit, rank, $(opt.rotatablePlane));
		card.id = id;
		items[id] = card;
		return card;
	}

	function createDeck(id) {
		card = new cards.Deck($(opt.rotatablePlane));
		card.id = id;
		items[id] = card;
	}

	function createMenu() {
	}

	function getById(id) {
		return items[id];
	}

	function setPlayerRotation(deg) {
		opt.playerRotation = deg;
		$('.player-rotated').css('transform', 'rotate('+deg+'deg)');
	}

	function setPlayerDisabled(disabled) {

	}


	return {
		options: opt,
		init: init,
		createCard: createCard,
		getById: getById,
		setPlayerRotation: setPlayerRotation,
		setPlayerDisabled: setPlayerDisabled,
	};
})();

if (typeof module !== 'undefined') {
    module.exports = cards362;
}

