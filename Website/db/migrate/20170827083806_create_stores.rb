class CreateStores < ActiveRecord::Migration[5.1]
  def change
    create_table :stores do |t|
    	t.string 		 :name, null: false, default: ''
    	t.string		 :city, null: false, default: ''
    	t.references :user, null: false, index: true, foreign_key: true

      t.timestamps
    end
  end
end
