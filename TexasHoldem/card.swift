enum Rank: Int {
  case two = 1
  case three, four, five, six, seven, eight, nine, ten
  case jack, queen, king, ace

  init?(value: String) {
    switch value {
      case "A": self = .ace
      case "2": self = .two
      case "3": self = .three
      case "4": self = .four
      case "5": self = .five
      case "6": self = .six
      case "7": self = .seven
      case "8": self = .eight
      case "9": self = .nine
      case "T": self = .ten
      case "J": self = .jack
      case "Q": self = .queen
      case "K": self = .king
      default: return nil
    }
  }
}

enum Suit: String {
  case spades = "S"
  case hearts = "H"
  case diamonds = "D"
  case clubs = "C"
}

class Card {
  var rank: Rank
  var suit: Suit

  init(_ spec: String) {
    let rank = String(spec[spec.startIndex])
    let suit = String(spec[spec.index(spec.startIndex, offsetBy: 1)])

    self.rank = Rank(value: rank)!
    self.suit = Suit(rawValue: suit)!
  }

  func compareTo(_ another: Card) -> Int {
    if self.rank.rawValue == another.rank.rawValue {
      return 0
    } else if self.rank.rawValue > another.rank.rawValue {
      return 1
    } else {
      return -1
    }
  }
}