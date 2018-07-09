class Micropost < ApplicationRecord
  validates :content, length: { maximum: 140 }, presence: true
  belongs_to :user
end
