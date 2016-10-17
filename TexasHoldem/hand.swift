class Hand {
  var cards: [Card]
  var figure: Figure

  init(cards: [Card]) {
    self.cards = cards
    self.figure = Figure(cards: cards)
  }
}